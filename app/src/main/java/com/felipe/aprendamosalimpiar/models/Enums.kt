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

enum class EstadoCaballo {
    muySucio,
    algoSucio,
    limpio,
    muyLimpio;


    fun limpiar(): EstadoCaballo {
        return when (this) {
            muySucio -> algoSucio
            algoSucio -> limpio
            limpio -> muyLimpio
            muyLimpio -> muyLimpio
        }
    }
}




enum class PosicionLimpieza(val descripcion: String) {
    DELANTE("Delante del caballo"),
    DETRAS("Detrás del caballo"),
    IZQUIERDA("A la izquierda del caballo"),
    DERECHA("A la derecha del caballo"),
    ARRIBA("Encima del caballo"),
    ABAJO("Debajo del caballo")
}



enum class ParteCuerpo(
    val imagenResId: Int ,
    val tipoPosicionLimpieza: PosicionLimpieza,
)
{
    CABEZA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    CUELLO(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    PALETA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    LOMO(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    PANZA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    ANCA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    MANOS(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    PATAS(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    VERIJA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    CUERPO_GENERAL(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    CRINES(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    COLA(R.drawable.cabeza_4,PosicionLimpieza.DERECHA),
    VASOS(R.drawable.cabeza_4,PosicionLimpieza.DERECHA)
}

