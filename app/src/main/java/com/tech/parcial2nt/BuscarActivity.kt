package com.tech.parcial2nt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_buscar.*

class BuscarActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        val helper = HelperBD(this)

        buscarb.setOnClickListener {

            val r: ModeloPersona? = helper.BuscarPersona(Integer.parseInt(ced.text.toString()))

            if(r == null)
            {
                Toast.makeText(this, "PERSONA NO REGISTRADA", Toast.LENGTH_SHORT).show()
            }
            else
            {
                cedulab.text = "Cedula: " + r.cedula
                nombresb.text = "Nombre: " + r.nombres
                nivelb.text = "Nivel Educativo: " + r.niveledu
                estratob.text = "Estrato: " + r.estrato
                salariob.text = "Salario: " + r.salario
            }
        }

    }
}
