package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("PDM24.1","No onCreate, $percentual")

        percentual=0.7
        val btCalc: Button = findViewById(R.id.btCalcular)
        val swPercentual: Switch = findViewById(R.id.swPercentual)
        val edAlcool: EditText = findViewById(R.id.edAlcool)
        val edGasolina: EditText = findViewById(R.id.edGasolina)
        val textMsg:TextView= findViewById(R.id.textMsg)

        swPercentual.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) 0.75 else 0.7
        }

        btCalc.setOnClickListener(View.OnClickListener {
            val precoGasolina = edGasolina.text.toString().toDoubleOrNull() ?: 0.0
            val precoAlcool = edAlcool.text.toString().toDoubleOrNull() ?: 0.0


            var texto = calculo(precoGasolina, precoAlcool, percentual)

            textMsg.text= texto
            Log.d("PDM24","No btCalcular, $percentual")
            Log.d("PDM24","Calculo: , $texto")
        })
    }
    override fun onResume(){
        super.onResume()
        Log.d("PDM24","No onResume, $percentual")
    }
    override fun onStart(){
        super.onStart()
        Log.v("PDM24","No onStart")
    }
    override fun onPause(){
        super.onPause()
        Log.e("PDM24","No onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.w("PDM24","No onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.wtf("PDM24","No Destroy")
    }

    fun calculo(alcool: Double, gasolina: Double, percent: Double): String {
        var resultado = gasolina * percent
        Log.d("PDM24","Resultado: , $resultado")
        Log.d("PDM24","alcool: , $alcool")

        if (alcool <= resultado) {
            return "O alcool é mais rentável"
        }
        else {
            return "O alcool não é rentável"
        }
    }
}