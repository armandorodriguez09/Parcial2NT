package com.tech.parcial2nt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_main.*

class ActualizarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)

        val helper = HelperBD(this)


        actualizar1.setOnClickListener {
            if( helper.ActualizarPersona(cedulaa.text.toString().toInt(), nombresa.text.toString()
                , niveleda.selectedItem.toString(), estratoa.selectedItem.toString().toInt()
                , salarioa.text.toString().toFloat()) != 0)
            {
                Toast.makeText(this, "Persona actualizada", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Persona no esta registrada", Toast.LENGTH_SHORT).show()



        }



    }
}