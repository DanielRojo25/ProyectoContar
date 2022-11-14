package com.example.proyectocontar

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.proyectocontar.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mp : MediaPlayer

    var iniciar = true
    var pausar  = false
    var indice = 0
    var bandera = false

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


    var audiosNumeros = arrayListOf(R.raw.uno, R.raw.dos, R.raw.tres, R.raw.cuatro, R.raw.cinco,
        R.raw.seis, R.raw.siete, R.raw.ocho, R.raw.nueve, R.raw.diez,
        R.raw.once, R.raw.doce, R.raw.trece, R.raw.catorce, R.raw.quince,
        R.raw.dieciseis, R.raw.diecisiete, R.raw.dieciocho, R.raw.diecinueve, R.raw.veinte,
        R.raw.veintiuno, R.raw.veintidos, R.raw.veintitres, R.raw.veinticuatro, R.raw.veinticinco,
        R.raw.veintiseis, R.raw.veintisiete, R.raw.veintiocho, R.raw.veintinueve, R.raw.treinta,
        R.raw.treintayuno, R.raw.treintaydos, R.raw.treintaytres, R.raw.treintaycuatro, R.raw.treintaycinco,
        R.raw.treintayseis, R.raw.treintaysiete, R.raw.treintayocho, R.raw.treintaynueve, R.raw.cuarenta,
        R.raw.cuarentayuno, R.raw.cuarentaydos, R.raw.cuarentaytres, R.raw.cuarentaycuatro, R.raw.cuarentaycinco,
        R.raw.cuarentayseis, R.raw.cuarentaysiete, R.raw.cuarentayocho, R.raw.cuarentaynueve, R.raw.cincuenta,
        R.raw.cincuentayuno, R.raw.cincuentaydos, R.raw.cincuentaytres, R.raw.cincuentaycuatro, R.raw.cincuentaycinco,
        R.raw.cincuentayseis, R.raw.cincuentaysiete, R.raw.cincuentayocho, R.raw.cincuentaynueve, R.raw.sesenta,
        R.raw.sesentayuno, R.raw.sesentaydos, R.raw.sesentaytres, R.raw.sesentaycuatro, R.raw.sesentaycinco,
        R.raw.sesentayseis, R.raw.sesentaysiete, R.raw.sesentayocho, R.raw.sesentaynueve, R.raw.setenta,
        R.raw.setentayuno, R.raw.setentaydos, R.raw.setentaytres, R.raw.setentaycuatro, R.raw.setentaycinco,
        R.raw.setentayseis, R.raw.setentaysiete, R.raw.setentayocho, R.raw.setentaynueve, R.raw.ochenta,
        R.raw.ochentayuno, R.raw.ochentaydos, R.raw.ochentaytres, R.raw.ochentaycuatro, R.raw.ochentaycinco,
        R.raw.ochentayseis, R.raw.ochentaysiete, R.raw.ochentayocho, R.raw.ochentaynueve, R.raw.noventa,
        R.raw.noventayuno, R.raw.noventaydos, R.raw.noventaytres, R.raw.noventaycuatro, R.raw.noventaycinco,
        R.raw.noventayseis, R.raw.noventaysiete, R.raw.noventayocho, R.raw.noventaynueve, R.raw.cien)

    fun corrutina() = GlobalScope.launch {
        while (iniciar){

            if(!pausar){
                runOnUiThread{
                    recorrerNumeros()
                }
                delay(2000)
            }
            if(indice == 100) pausar()
        }
    }

    fun intro(){
        AlertDialog.Builder(this)
            .setTitle("BIENVENIDO")
            .setMessage("EN ESTA APLICACIÓN PODRÁS APRENDER LOS NÚMEROS DEL UNO AL CIEN, TAMBIÉN SE PODRÁ REPASAR LO APRENDIDO " +
                    "CON UN PEQUEÑO JUEGO DONDE TENDRÁ QUE ORDENARLOS DEL UNO AL DIEZ.")
            .setPositiveButton("ACEPTAR"){_,_->}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "1,2,3.. A contar!"

        intro()

        binding.btnIniciar.setOnClickListener {
            corrutina()
            binding.btnIniciar.isClickable=false
        }

        binding.btnPausa.setOnClickListener {
            cambiarTexto()
        }

        binding.btnJugar.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        binding.btnReiniciar.setOnClickListener {
            terminar()
            binding.btnIniciar.isClickable = true
        }

    }

    fun recorrerNumeros(){
        if(indice < 100) {
            binding.imagen.setImageResource(cartasNumeros[indice])
            mp = MediaPlayer.create(this, audiosNumeros[indice])
            mp.start()
            indice++
        }else if(indice==100) {
            mp.stop()
            runOnUiThread {
                binding.texto.text = "Juego Terminado!"
            }
        }else terminar()

    }

    fun terminar(){
        iniciar = false
        mp.stop()
        binding.imagen.setImageResource(R.drawable.numeros)
    }

    fun pausar(){
        pausar = pausar == false
    }

    fun cambiarTexto (){
        if (bandera){
            binding.btnPausa.text="PAUSA"
            pausar()

        }else{
            binding.btnPausa.text="CONTINUAR"
            pausar()
        }
        bandera = !bandera
    }
}