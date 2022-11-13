package com.example.proyectocontar

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var rango = arrayOf(1,10)
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

        rndmUno.setImageResource(R.drawable.uno)
        rndmUno.setOnLongClickListener(longClickListener)

        unoOrden.setOnDragListener(dragListener)

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
                rndmUno.setBackgroundColor(Color.TRANSPARENT)
                rndmUno.setImageResource(0)
                unoOrden.setImageResource(R.drawable.uno)
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

    fun randomNum() : Int{
        return (rango[0]..rango[1]).shuffled().first()
    }

}