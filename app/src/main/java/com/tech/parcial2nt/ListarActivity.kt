package com.tech.parcial2nt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listar.*

class ListarActivity : AppCompatActivity() {

    var informacion: ArrayList<ModeloPersona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        val helper = HelperBD(this)
        informacion = helper.ListarPersonas

        val adapatador = CustomAdapter(this, this.informacion!!)

        listav.adapter = adapatador





    }
}
