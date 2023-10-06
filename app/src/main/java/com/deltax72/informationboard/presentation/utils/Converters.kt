package com.deltax72.informationboard.presentation.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import java.io.ByteArrayOutputStream

fun ImageView.toByteArray(): ByteArray {
    val bitmap = (drawable as BitmapDrawable).bitmap
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    return outputStream.toByteArray()
}

fun convertByteArrayToDrawable(byteArray: ByteArray): Drawable {
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    return BitmapDrawable(Resources.getSystem(), bitmap)
}

fun Drawable.toByteArray(): ByteArray {
    val bitmap = (this as BitmapDrawable).bitmap
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    return outputStream.toByteArray()
}