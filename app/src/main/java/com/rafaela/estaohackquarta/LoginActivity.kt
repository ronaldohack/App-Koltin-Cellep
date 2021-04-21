package com.rafaela.estaohackquarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Criando o clique do Botão Entrar

        btnEntrar.setOnClickListener{

            // recuperando os valores digitados
            val usuario = edtUsuario.text.toString().trim()
            val senha= edtSenha.text.toString().trim()

            //Verificando se o usuário ou senha estão corretos

            

            if(usuario.isEmpty()){
                txvResultado.text = "Usuário Vazio"
            }else if(senha.isEmpty()){
                txvResultado.text = "Senha Vazia"
            }else if(usuario=="Ronaldo"){
                if(senha=="123"){
                    txvResultado.text="usuario logado"
                }else{
                    txvResultado.text="senha incorreta"
                }
            }else{
                txvResultado.text="usuario incorreto"
                        
            }

        }

        btnCadastro.setOnClickListener {
            startActivity(Intent(this@LoginActivity,CadastroActivity::class.java))
        }
    }
}
