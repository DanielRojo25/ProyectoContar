package com.example.proyectocontar

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class Lienzo (puntero : MainActivity2) : View(puntero) {

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()
        c.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.uno), 100f, 100f, p)

    }
}