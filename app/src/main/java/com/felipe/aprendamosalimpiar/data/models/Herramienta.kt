package com.felipe.aprendamosalimpiar.data.models

import com.felipe.aprendamosalimpiar.R

enum class Herramienta(
    val tipoMovimiento: TipoMovimiento,
    val partesPermitidas: List<ParteCuerpo>,
    val imagenResId: Int // ID del drawable

) {
    RASQUETA_BLANDA(TipoMovimiento.CIRCULAR, listOf(
        ParteCuerpo.CABEZA,
        ParteCuerpo.MANOS,
        ParteCuerpo.PATAS
    ), R.drawable.rasqueta_blanda2),

    RASQUETA_DURA(TipoMovimiento.CIRCULAR, listOf(
        ParteCuerpo.CUELLO,
        ParteCuerpo.PALETA,
        ParteCuerpo.LOMO,
        ParteCuerpo.PANZA,
        ParteCuerpo.ANCA
    ),R.drawable.rasqueta_dura),

    CEPILLO_DURO(TipoMovimiento.VERTICAL, listOf(
        ParteCuerpo.CRINES,
        ParteCuerpo.COLA
    ),R.drawable.cepillo_duro),

    CEPILLO_BLANDO(TipoMovimiento.VERTICAL, listOf(
        ParteCuerpo.CUERPO_GENERAL
    ),R.drawable.cepillo_blando),

    ESCARBA_VASOS(TipoMovimiento.HORIZONTAL, listOf(
        ParteCuerpo.VASOS
    ),R.drawable.escarba_vasos);
}
