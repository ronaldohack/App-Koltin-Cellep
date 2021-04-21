package com.rafaela.estaohackquarta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Abrindo o Sharepreference

        val minhaPreferencia = getSharedPreferences("minha preferencia", Context.MODE_PRIVATE)


        //Recuperando as informações do shared preference
        val nome =  minhaPreferencia.getString("nome","erro no shared preference")
        val sobrenome =  minhaPreferencia.getString("sobrenome","erro no shared preference")
        val email =  minhaPreferencia.getString("email","erro no shared preference")
        val sexo =  minhaPreferencia.getString("sexo","erro no shared preference")

            edtNome.text ="$nome $sobrenome"
            edtSexo.text = email
            edtSexo.text = sexo

        btnSair.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finishAffinity()
        }


        btnSite.setOnClickListener {
            startActivity(Intent(this@MainActivity,WebActivity::class.java))
            finishAffinity()
        }
    }
}
