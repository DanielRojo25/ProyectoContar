package com.example.proyectocontar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.proyectocontar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var numeros : HiloNumeros
    lateinit var mp : MediaPlayer
    var bandera = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        numeros = HiloNumeros(this)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            try {
                numeros.start()
            }catch (e:Exception){
                Toast.makeText(this,"Solo se puede iniciar una vez!",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnPausa.setOnClickListener {
            cambiarTexto(false)

        }

        binding.btnTerminar.setOnClickListener {
            numeros.terminar()
        }

    }

    fun cambiarTexto (textStatus : Boolean){
        if (textStatus){
            binding.btnPausa.text="CONTINUAR"
            numeros.pausar()

        }else{
            binding.btnPausa.text="PAUSA"
            numeros.pausar()
        }

    }
}

class HiloNumeros(puntero:MainActivity):Thread(){
    var p = puntero

    var iniciar = true
    var pausar  = false
    var indice = -1

    var cartasNumeros = arrayListOf(R.drawable.uno, R.drawable.dos, R.drawable.tres, R.drawable.cuatro, R.drawable.cinco,
                                    R.drawable.seis, R.drawable.siete, R.drawable.ocho, R.drawable.nueve, R.drawable.diez,
                                    R.drawable.once, R.drawable.doce, R.drawable.trece, R.drawable.catorce, R.drawable.quince,
                                    R.drawable.dieciseis, R.drawable.diecisiete, R.drawable.dieciocho, R.drawable.diecinueve, R.drawable.veinte,
                                    R.drawable.veintiuno, R.drawable.veintidos, R.drawable.veintitres, R.drawable.veinticuatro, R.drawable.veinticinco,
                                    R.drawable.veintiseis, R.drawable.veintisiete, R.drawable.veintiocho, R.drawable.veintinueve, R.drawable.treinta,
                                    R.drawable.treintayuno, R.drawable.treintaydos, R.drawable.treintaytres, R.drawable.treintaycuatro, R.drawable.treintaycinco,
                                    R.drawable.treintayseis, R.drawable.treintaysiete, R.drawable.treintayocho, R.drawable.treintaynueve, R.drawable.cuarenta,
                                    R.drawable.cuarentayuno, R.drawable.cuarentaydos, R.drawable.cuarentaytres, R.drawable.cuarentaycuatro, R.drawable.cuarentaycinco,
                                    R.drawable.cuarentayseis, R.drawable.cuarentaysiete, R.drawable.cuarentayocho, R.drawable.cuarentaynueve, R.drawable.cincuenta,
                                    R.drawable.cincuentayuno, R.drawable.cincuentaydos, R.drawable.cincuentaytres, R.drawable.cincuentaycuatro, R.drawable.cincuentaycinco,
                                    R.drawable.cincuentayseis, R.drawable.cincuentaysiete, R.drawable.cincuentayocho, R.drawable.cincuentaynueve, R.drawable.sesenta,
                                    R.drawable.sesentayuno, R.drawable.sesentaydos, R.drawable.sesentaytres, R.drawable.sesentaycuatro, R.drawable.sesentaycinco,
                                    R.drawable.sesentayseis, R.drawable.sesentaysiete, R.drawable.sesentayocho, R.drawable.sesentaynueve, R.drawable.setenta,
                                    R.drawable.setentayuno, R.drawable.setentaydos, R.drawable.setentaytres, R.drawable.setentaycuatro, R.drawable.setentaycinco,
                                    R.drawable.setentayseis, R.drawable.setentaysiete, R.drawable.setentayocho, R.drawable.setentaynueve, R.drawable.ochenta,
                                    R.drawable.ochentayuno, R.drawable.ochentaydos, R.drawable.ochentaytres, R.drawable.ochentaycuatro, R.drawable.ochentaycinco,
                                    R.drawable.ochentayseis, R.drawable.ochentaysiete, R.drawable.ochentayocho, R.drawable.ochentaynueve, R.drawable.noventa,
                                    R.drawable.noventayuno, R.drawable.noventaydos, R.drawable.noventaytres, R.drawable.noventaycuatro, R.drawable.noventaycinco,
                                    R.drawable.noventayseis, R.drawable.noventaysiete, R.drawable.noventayocho, R.drawable.noventaynueve, R.drawable.cien)

    fun recorrerNumeros(){

        indice++
        if (indice == cartasNumeros.size) indice = 99
        p.binding.imagen.setImageResource(cartasNumeros[indice])

        if(indice==99){
            p.runOnUiThread{
                p.binding.texto.text="Juego Terminado!"
            }
        }

    }

    fun terminar(){
        iniciar = false
        //p.mp.stop()
        p.binding.imagen.setImageResource(R.drawable.numeros)
    }

    fun pausar(){
        pausar = pausar == false
    }

    override fun run() {
        super.run()

        while (iniciar){

            if(!pausar){

                p.runOnUiThread{
                    recorrerNumeros()
                }

                sleep(1000)

            }

        }
    }

}