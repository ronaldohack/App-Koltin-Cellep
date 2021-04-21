package com.rafaela.estaohackquarta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //criando o meu sharepreference

        val minhaPreferencia = getSharedPreferences("minha preferencia", Context.MODE_PRIVATE)

        val meuEditor=minhaPreferencia.edit()

        //criando lista de sexo

        val listaSexo = arrayListOf("selecione o sexo","masculino","feminino")

        //criando meu adapter
        val adapterSexo = ArrayAdapter(
            this@CadastroActivity,android.R.layout.simple_spinner_dropdown_item,listaSexo)

        //atribuindo meu adapter ao spinner
        spnSexo.adapter=adapterSexo


        // criando a ação clique do botao
        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtSexo.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){

                // criando o Toast
                Toast.makeText(this@CadastroActivity,"preencha todos os campos",Toast.LENGTH_LONG).show()

            }else if (spnSexo.selectedItem == "selecione o sexo"){

                // criando alerta
                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("sexo")
                    .setMessage("preencha o sexo")
                    .setPositiveButton("ok"){_,_ ->

                    }
                    .create()
                    .show()

            }else{
                meuEditor.putString("nome",nome).apply()
                meuEditor.putString("sobrenome",sobrenome).apply()
                meuEditor.putString("email",email).apply()
                meuEditor.putString("senha",senha).apply()
                meuEditor.putString("sexo",spnSexo.selectedItem.toString()).apply()

                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("sucessoo")
                    .setMessage("Usuário cadastrado com Sucesso")
                    .setPositiveButton("ok"){_,_->
                        startActivity(Intent(this@CadastroActivity,MainActivity::class.java))
                    }

                    .setCancelable(false)
                    .create()
                    .show()


            }

        }


    }
}
