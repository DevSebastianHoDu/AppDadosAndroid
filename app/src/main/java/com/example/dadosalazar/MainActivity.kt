package com.example.dadosalazar

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Esta Actividad permite al usuario lanza un dado y mostrar su resultado
 * en la pantalla
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tirarDado()

        // Variable tirar dedo que ubica el buton
        val botonTirarDado: Button = findViewById(R.id.button)
        botonTirarDado.setOnClickListener { tirarDado() }
    }

    /**
     * Funcion que permite tirar y mostrar el resultado en pantalla
     */

    private fun tirarDado() {
        //Se crea un nuevo dado con 6 caras
        val dado = Dado(6)
        val dadoTirado = dado.tirar()

        //Metodo para llamar la imagen view
        val imagenDados: ImageView = findViewById(R.id.imageView)

        //Metodo para cambiar la imagen


        val drawableResource = when (dadoTirado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imagenDados.setImageResource(drawableResource)

        imagenDados.contentDescription = dadoTirado.toString()
    }
}

class Dado(private val numeroLados: Int) {
    //Funcion de generar un numero aleatorio
    fun tirar(): Int {
        return (1..numeroLados).random()
    }
}