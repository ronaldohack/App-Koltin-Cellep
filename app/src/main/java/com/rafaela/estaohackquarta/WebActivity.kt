package com.rafaela.estaohackquarta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //ativando javascript
        wbvSite.settings.javaScriptEnabled = true

        //Passando a url do site
        wbvSite.loadUrl("http://br.cellep.com")
    }
}