package com.felipe.aprendamosalimpiar.models

import android.graphics.drawable.Drawable
import com.felipe.aprendamosalimpiar.R

enum class TipoMovimiento {
    VERTICAL,
    CIRCULAR,
    HORIZONTAL
}


enum class Dificultad {
    FACIL,
    MEDIO,
    DIFICIL
}

enum class ParteCuerpo(
    val imagenResId: Int // ID del drawable
)
{
    CABEZA(R.drawable.cabeza_4),
    CUELLO(R.drawable.cabeza_4),
    PALETA(R.drawable.cabeza_4),
    LOMO(R.drawable.cabeza_4),
    PANZA(R.drawable.cabeza_4),
    ANCA(R.drawable.cabeza_4),
    MANOS(R.drawable.cabeza_4),
    PATAS(R.drawable.cabeza_4),
    VERIJA(R.drawable.cabeza_4),
    CUERPO_GENERAL(R.drawable.cabeza_4),
    CRINES(R.drawable.cabeza_4),
    COLA(R.drawable.cabeza_4),
    VASOS(R.drawable.cabeza_4)
}

