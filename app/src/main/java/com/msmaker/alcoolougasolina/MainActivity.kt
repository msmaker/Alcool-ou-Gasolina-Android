package com.msmaker.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View) {
        //Recuperar valores digitados
        //val  precoAlcool = findViewById<EditText>(R.id.editPrecoGasolina)
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()
        val validaCampos = validarCampos(precoAlcool, precoGasolina);
        if (validaCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            textResultado.text = "Preencha os preços primeiro!"
        }

    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        //Converter valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        //se resultado for >= 0.7 melhor utlizar gasolina
        val resultadoPreco = valorAlcool / valorGasolina

        if(resultadoPreco >=0.7){
            textResultado.text = "Melhor utilizar Gasolina!"
        }else{
            textResultado.text = "Melhor utilizar Alcool!"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        var camporValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")) {
            camporValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camporValidados = false
        }
        return camporValidados
    }
}



