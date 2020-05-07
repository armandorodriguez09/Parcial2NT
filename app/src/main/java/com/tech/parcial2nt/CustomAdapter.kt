package com.tech.parcial2nt

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.listvw.view.*

class CustomAdapter(private val context: Context, private val modeloPersonaArrayList: ArrayList<ModeloPersona>) :
    BaseAdapter() {


    override fun getCount(): Int {
        return modeloPersonaArrayList.size
    }

    override fun getItem(position: Int): Any {
        return modeloPersonaArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var cv = convertView
        val holder: ViewHolder

        if (cv == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            cv = inflater.inflate(R.layout.listvw, null, true)

            holder.cedula = cv.cedulal
            holder.names = cv.name
            holder.niveleducativo= cv.nivell
            holder.estrato = cv.estratol
            holder.salario = cv.salariol


            cv!!.tag = holder

        }
        else
        {
            holder = cv.tag as ViewHolder
        }

        holder.cedula!!.text = "Cedula: " + modeloPersonaArrayList[position].cedula
        holder.names!!.text = "Nombres: " + modeloPersonaArrayList[position].nombres
        holder.niveleducativo!!.text = "Nivel de Educacion: " + modeloPersonaArrayList[position].niveledu
        holder.estrato!!.text = "Estrato: " + modeloPersonaArrayList[position].estrato
        holder.salario!!.text = "Salario: " + modeloPersonaArrayList[position].salario



        return cv
    }

    private inner class ViewHolder
    {
        var cedula: TextView? = null
        var names: TextView? = null
        var niveleducativo: TextView? = null
        var estrato: TextView? = null
        var salario: TextView? = null
    }
}