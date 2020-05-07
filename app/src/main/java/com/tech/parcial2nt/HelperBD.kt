package com.tech.parcial2nt

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.ArrayList

class HelperBD(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    val ListarPersonas: ArrayList<ModeloPersona>
        get() {
            val arrayPersonas = ArrayList<ModeloPersona>()

            val selectQuery = "SELECT  * FROM $TABLE_USER"
            val db = this.readableDatabase
            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {
                    val modelo = ModeloPersona()
                    modelo.cedula = c.getInt(c.getColumnIndex(CEDULA))
                    modelo.nombres = c.getString(c.getColumnIndex(NOMBRES))
                    modelo.niveledu = c.getString(c.getColumnIndex(NIVELEDU))
                    modelo.estrato = c.getInt(c.getColumnIndex(ESTRATO))
                    modelo.salario = c.getFloat(c.getColumnIndex(SALARIO))
                    arrayPersonas.add(modelo)
                } while (c.moveToNext())
            }
            return arrayPersonas
        }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS '$TABLE_USER'")
        onCreate(db)
    }

    fun BuscarPersona(ced: Int): ModeloPersona?
    {
        val selectQuery = "SELECT  * FROM $TABLE_USER where $CEDULA = $ced"
        val db = this.readableDatabase
        val c = db.rawQuery(selectQuery, null)
        if (c.moveToFirst()) {
            val result = ModeloPersona()
            result.cedula = c.getInt(c.getColumnIndex(CEDULA))
            result.nombres = c.getString(c.getColumnIndex(NOMBRES))
            result.niveledu = c.getString(c.getColumnIndex(NIVELEDU))
            result.estrato = c.getInt(c.getColumnIndex(ESTRATO))
            result.salario = c.getFloat(c.getColumnIndex(SALARIO))
            return result
        }
        return null
    }



    fun addPersona(cedual: Int, name: String, nivel: String, sal: Float,
                      estrato: Int): Long {

        val db = this.writableDatabase
        val values = ContentValues()
        values.put(CEDULA, cedual)
        values.put(NOMBRES, name)
        values.put(NIVELEDU, nivel)
        values.put(ESTRATO, estrato)
        values.put(SALARIO, sal)

        return db.insert(TABLE_USER, null, values)
    }

    fun ActualizarPersona(ced: Int, name: String, nivel: String, estrato: Int, sal: Float): Int {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(NOMBRES, name)
        values.put(NIVELEDU, nivel)
        values.put(ESTRATO, estrato)
        values.put(SALARIO, sal)

        return db.update(
            TABLE_USER, values, "$CEDULA = ?",
            arrayOf(ced.toString())
        )
    }

    fun BorrarPersona(ced: Int): Int {


        val db = this.writableDatabase
        var r = db.delete(
            TABLE_USER, "$CEDULA = ?",
            arrayOf(ced.toString())
        )

        return r
    }

    companion object {

        var DATABASE_NAME = "bdpersonas"
        private val DATABASE_VERSION = 1
        private val TABLE_USER = "personas"
        private val CEDULA = "cedula"
        private val NOMBRES = "nombres"
        private val SALARIO = "salario"
        private val ESTRATO = "estrato"
        private val NIVELEDU = "niveledu"


        private val CREATE_TABLE = ("CREATE TABLE "
                + TABLE_USER + "(" + CEDULA
                + " INTEGER PRIMARY KEY, "
                + NOMBRES + " TEXT, " + NIVELEDU + " TEXT, "
                + ESTRATO + " NUMBER, " + SALARIO + " FLOAT);")
    }

}
