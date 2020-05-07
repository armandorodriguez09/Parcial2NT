package com.tech.parcial2nt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.c_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = HelperBD(this)

        registrar.setOnClickListener {

            helper!!.addPersona(cedula.text.toString().toInt(), nombres.text.toString(), niveled.selectedItem.toString()
                , salario.text.toString().toFloat(), estrato.selectedItem.toString().toInt())

            cedula.setText("")
            nombres.setText("")
            salario.setText("")

            Toast.makeText(this, "GUARDADO!", Toast.LENGTH_SHORT).show()
        }

        eliminar.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.c_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Digite Cedula para eliminar")
            val  mAlertDialog = mBuilder.show()

            mDialogView.eli.setOnClickListener {

                if(helper.BorrarPersona(mDialogView.cedeliminar.text.toString().toInt()) != 0)
                    Toast.makeText(this, "Persona eliminada", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Persona no esta registrada", Toast.LENGTH_SHORT).show()

                mAlertDialog.dismiss()
            }
        }

        buscar.setOnClickListener {
            val intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }

        listar.setOnClickListener {
            val intent = Intent(this, ListarActivity::class.java)
            startActivity(intent)
        }

        actualizar.setOnClickListener {
            val intent = Intent(this, ActualizarActivity::class.java)
            startActivity(intent)
        }

    }
}
