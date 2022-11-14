package com.example.proyectocontar

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {


    var rangoDiez = (0..9).shuffled()
    var rangoVeinte = (10..19).shuffled()
    var rangoTreinta = (20..29).shuffled()
    var rangoCuarenta = (30..39).shuffled()
    var rangoCincuenta = (40..49).shuffled()
    var rangoSesenta = (50..59).shuffled()
    var rangoSetenta = (60..69).shuffled()
    var rangoOchenta = (70..79).shuffled()
    var rangoNoventa = (80..89).shuffled()
    var rangoCien = (90..99).shuffled()

    private var orden = arrayOfNulls<ImageView>(10)
    private var elementos = arrayOfNulls<ImageView>(10)



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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "1,2,3.. A contar!"

        btnVolver.setOnClickListener {
            this.finish()
        }

        btnReiniciar.setOnClickListener{
            rangoDiez = (0..9).shuffled()
            mezclarNumeros(rangoDiez)

            unoOrden.setImageResource(0)
            unoOrden.setBackgroundColor(Color.WHITE)
            rndmUno.setImageResource(cartasNumeros[rangoDiez[0]])

            dosOrden.setImageResource(0)
            dosOrden.setBackgroundColor(Color.WHITE)
            rndmDos.setImageResource(cartasNumeros[rangoDiez[1]])

            tresOrden.setImageResource(0)
            tresOrden.setBackgroundColor(Color.WHITE)
            rndmTres.setImageResource(cartasNumeros[rangoDiez[2]])

            cuatroOrden.setImageResource(0)
            cuatroOrden.setBackgroundColor(Color.WHITE)
            rndmCuatro.setImageResource(cartasNumeros[rangoDiez[3]])

            cincoOrden.setImageResource(0)
            cincoOrden.setBackgroundColor(Color.WHITE)
            rndmCinco.setImageResource(cartasNumeros[rangoDiez[4]])

            seisOrden.setImageResource(0)
            seisOrden.setBackgroundColor(Color.WHITE)
            rndmSeis.setImageResource(cartasNumeros[rangoDiez[5]])

            sieteOrden.setImageResource(0)
            sieteOrden.setBackgroundColor(Color.WHITE)
            rndmSiete.setImageResource(cartasNumeros[rangoDiez[6]])

            ochoOrden.setImageResource(0)
            ochoOrden.setBackgroundColor(Color.WHITE)
            rndmOcho.setImageResource(cartasNumeros[rangoDiez[7]])

            nueveOrden.setImageResource(0)
            nueveOrden.setBackgroundColor(Color.WHITE)
            rndmNueve.setImageResource(cartasNumeros[rangoDiez[8]])

            diezOrden.setImageResource(0)
            diezOrden.setBackgroundColor(Color.WHITE)
            rndmDiez.setImageResource(cartasNumeros[rangoDiez[9]])

        }

        mezclarNumeros(rangoDiez)

        orden[0] = unoOrden
        orden[1] = dosOrden
        orden[2] = tresOrden
        orden[3] = cuatroOrden
        orden[4] = cincoOrden
        orden[5] = seisOrden
        orden[6] = sieteOrden
        orden[7] = ochoOrden
        orden[8] = nueveOrden
        orden[9] = diezOrden

        unoOrden.tag = "0"
        dosOrden.tag = "1"
        tresOrden.tag = "2"
        cuatroOrden.tag = "3"
        cincoOrden.tag = "4"
        seisOrden.tag = "5"
        sieteOrden.tag = "6"
        ochoOrden.tag = "7"
        nueveOrden.tag = "8"
        diezOrden.tag = "9"

        rndmUno.setImageResource(cartasNumeros[rangoDiez[0]])
        rndmUno.tag = rangoDiez[0].toString()
        rndmUno.setOnLongClickListener(longClickListener)

        rndmDos.setImageResource(cartasNumeros[rangoDiez[1]])
        rndmDos.tag = rangoDiez[1].toString()
        rndmDos.setOnLongClickListener(longClickListener)

        rndmTres.setImageResource(cartasNumeros[rangoDiez[2]])
        rndmTres.tag = rangoDiez[2].toString()
        rndmTres.setOnLongClickListener(longClickListener)

        rndmCuatro.setImageResource(cartasNumeros[rangoDiez[3]])
        rndmCuatro.tag = rangoDiez[3].toString()
        rndmCuatro.setOnLongClickListener(longClickListener)

        rndmCinco.setImageResource(cartasNumeros[rangoDiez[4]])
        rndmCinco.tag = rangoDiez[4].toString()
        rndmCinco.setOnLongClickListener(longClickListener)

        rndmSeis.setImageResource(cartasNumeros[rangoDiez[5]])
        rndmSeis.tag = rangoDiez[5].toString()
        rndmSeis.setOnLongClickListener(longClickListener)

        rndmSiete.setImageResource(cartasNumeros[rangoDiez[6]])
        rndmSiete.tag = rangoDiez[6].toString()
        rndmSiete.setOnLongClickListener(longClickListener)

        rndmOcho.setImageResource(cartasNumeros[rangoDiez[7]])
        rndmOcho.tag = rangoDiez[7].toString()
        rndmOcho.setOnLongClickListener(longClickListener)

        rndmNueve.setImageResource(cartasNumeros[rangoDiez[8]])
        rndmNueve.tag = rangoDiez[8].toString()
        rndmNueve.setOnLongClickListener(longClickListener)

        rndmDiez.setImageResource(cartasNumeros[rangoDiez[9]])
        rndmDiez.tag = rangoDiez[9].toString()
        rndmDiez.setOnLongClickListener(longClickListener)

        dragListeners()

    }

    private fun mezclarNumeros(lista : List<Int>){
        elementos[lista[0]] = rndmUno
        elementos[lista[1]] = rndmDos
        elementos[lista[2]] = rndmTres
        elementos[lista[3]] = rndmCuatro
        elementos[lista[4]] = rndmCinco
        elementos[lista[5]] = rndmSeis
        elementos[lista[6]] = rndmSiete
        elementos[lista[7]] = rndmOcho
        elementos[lista[8]] = rndmNueve
        elementos[lista[9]] = rndmDiez
    }

    private fun dragListeners() {
        unoOrden.setOnDragListener(dragListener)
        dosOrden.setOnDragListener(dragListener)
        tresOrden.setOnDragListener(dragListener)
        cuatroOrden.setOnDragListener(dragListener)
        cincoOrden.setOnDragListener(dragListener)
        seisOrden.setOnDragListener(dragListener)
        sieteOrden.setOnDragListener(dragListener)
        ochoOrden.setOnDragListener(dragListener)
        nueveOrden.setOnDragListener(dragListener)
        diezOrden.setOnDragListener(dragListener)
    }

    private val longClickListener = View.OnLongClickListener { v ->
        val item = ClipData.Item(v.tag as? CharSequence)

        val dragData = ClipData(
            v.tag as? CharSequence,
            arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
            item
        )

        val myShadow = MyDragShadowBuilder(v)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            v.startDragAndDrop(dragData, myShadow, null, 0)
        }else{
            v.startDrag(dragData, myShadow, null, 0)
        }
        true
    }

    private val dragListener = View.OnDragListener { v, event ->
        val receiverView:ImageView = v as ImageView

        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {

                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                true
            }
            DragEvent.ACTION_DROP -> {
                if(receiverView.tag as String == event.clipDescription.label){
                    when(receiverView.tag as String){
                        "0" -> {
                            elementos[0]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[0]!!.setImageResource(0)
                            orden[0]!!.setImageResource(cartasNumeros[0])
                        }
                        "1" -> {
                            elementos[1]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[1]!!.setImageResource(0)
                            orden[1]!!.setImageResource(cartasNumeros[1])
                        }
                        "2" -> {
                            elementos[2]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[2]!!.setImageResource(0)
                            orden[2]!!.setImageResource(cartasNumeros[2])
                        }
                        "3" -> {
                            elementos[3]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[3]!!.setImageResource(0)
                            orden[3]!!.setImageResource(cartasNumeros[3])
                        }
                        "4" -> {
                            elementos[4]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[4]!!.setImageResource(0)
                            orden[4]!!.setImageResource(cartasNumeros[4])
                        }
                        "5" -> {
                            elementos[5]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[5]!!.setImageResource(0)
                            orden[5]!!.setImageResource(cartasNumeros[5])
                        }
                        "6" -> {
                            elementos[6]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[6]!!.setImageResource(0)
                            orden[6]!!.setImageResource(cartasNumeros[6])
                        }
                        "7" -> {
                            elementos[7]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[7]!!.setImageResource(0)
                            orden[7]!!.setImageResource(cartasNumeros[7])
                        }
                        "8" -> {
                            elementos[8]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[8]!!.setImageResource(0)
                            orden[8]!!.setImageResource(cartasNumeros[8])
                        }
                        "9" -> {
                            elementos[9]!!.setBackgroundColor(Color.TRANSPARENT)
                            elementos[9]!!.setImageResource(0)
                            orden[9]!!.setImageResource(cartasNumeros[9])
                        }
                    }
                    if(elementos[0]!!.solidColor == Color.TRANSPARENT && elementos[1]!!.solidColor == Color.TRANSPARENT &&
                        elementos[2]!!.solidColor == Color.TRANSPARENT && elementos[3]!!.solidColor == Color.TRANSPARENT &&
                        elementos[4]!!.solidColor == Color.TRANSPARENT && elementos[5]!!.solidColor == Color.TRANSPARENT &&
                        elementos[6]!!.solidColor == Color.TRANSPARENT && elementos[7]!!.solidColor == Color.TRANSPARENT &&
                        elementos[8]!!.solidColor == Color.TRANSPARENT && elementos[9]!!.solidColor == Color.TRANSPARENT){
                        AlertDialog.Builder(this)
                            .setMessage("¡FELICIDADES, CONSEGUISTE ORDENAR TODOS LOS NÚMEROS!")
                            .setPositiveButton("Aceptar"){ _,_ ->

                            }
                            .show()
                    }
                }
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                true
            }
            else -> {
                false
            }
        }
    }

    private class MyDragShadowBuilder(val v: View) : View.DragShadowBuilder(v){
        override fun onProvideShadowMetrics(outShadowSize: Point, outShadowTouchPoint: Point) {
            outShadowSize.set(view.width, view.height)
            outShadowTouchPoint.set(view.width/2, view.height/2)
        }

        override fun onDrawShadow(canvas: Canvas) {
            v.draw(canvas)
        }
    }
}