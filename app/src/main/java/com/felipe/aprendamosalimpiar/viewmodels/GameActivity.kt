package com.felipe.aprendamosalimpiar.viewmodels

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.felipe.aprendamosalimpiar.R
import com.felipe.aprendamosalimpiar.models.Dificultad
import com.felipe.aprendamosalimpiar.models.Herramienta
import com.felipe.aprendamosalimpiar.models.NivelJuego
import com.felipe.aprendamosalimpiar.models.ParteCuerpo
import java.io.Serializable

class GameActivity : AppCompatActivity() {

    private lateinit var imgSilueta : ImageView

    private lateinit var imgCaballo : ImageView

    private lateinit var herramienta_1 : ImageView
    private lateinit var herramienta_2 : ImageView
    private lateinit var herramienta_3 : ImageView
    private lateinit var herramienta_4 : ImageView
    private lateinit var herramienta_5 : ImageView


    private lateinit var mancha_1 : ImageView
    private lateinit var mancha_2 : ImageView
    private lateinit var mancha_3 : ImageView
    private lateinit var mancha_4 : ImageView
    private lateinit var dificultad : Dificultad
    private lateinit var nivel : NivelJuego
    private lateinit var parteCuerpo: ParteCuerpo
    private lateinit var herramientaCorrecta: Herramienta
    private lateinit var herramientas : List<Herramienta>





    private fun setLevelDefalut(){
        dificultad = Dificultad.FACIL
        nivel = NivelJuego.NIVEL_1
    }

    private fun setImageSaturation(imageView: ImageView, saturation: Float) {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(saturation)
        imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }



    private fun cambiarEstadoDelCaballo(imgCaballo : ImageView,estado : Int) {
        when (estado) {
            1 -> {
                imgCaballo.imageAlpha = 128
                setImageSaturation(imgCaballo, 0f)   // 🟠 Muy sucio (blanco y negro)

            }

            2 -> {
                imgCaballo.imageAlpha = 150
                setImageSaturation(imgCaballo, 0.3f) // 🟡 Bastante sucio

            }

            3 -> {
                imgCaballo.imageAlpha = 200
                setImageSaturation(imgCaballo, 0.6f) // 🟢 Medio limpio

            }
            4  -> {
                imgCaballo.imageAlpha = 255

                setImageSaturation(imgCaballo, 1f)   // ✅ Completamente limpio


            }
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initComponents()
        initExtras()
        initPreGame()
        initView()


        cambiarEstadoDelCaballo(imgCaballo,4)



    }



    private fun initComponents() {
        imgSilueta = findViewById<ImageView>(R.id.imgSilueta)

        imgCaballo = findViewById<ImageView>(R.id.imgCaballo)

        mancha_1 = findViewById<ImageView>(R.id.mancha1)
        mancha_2 = findViewById<ImageView>(R.id.mancha2)
        mancha_3 = findViewById<ImageView>(R.id.mancha3)
        mancha_4 = findViewById<ImageView>(R.id.mancha4)



        herramienta_1 = findViewById<ImageView>(R.id.herramienta1)
        herramienta_2 = findViewById<ImageView>(R.id.herramienta2)
        herramienta_3 = findViewById<ImageView>(R.id.herramienta3)
        herramienta_4 = findViewById<ImageView>(R.id.herramienta4)
        herramienta_5 = findViewById<ImageView>(R.id.herramienta5)


    }


    private fun initExtras() {

        val nombreDificultad = intent.extras?.getString("EXTRA DIFICULTAD").orEmpty()
        val nombreNivel = intent.extras?.getString("EXTRA NIVEL").orEmpty()

        try {
            dificultad = Dificultad.valueOf(nombreDificultad)
            nivel = NivelJuego.valueOf(nombreNivel)

        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
            setLevelDefalut()

        }
    }






    private fun initPreGame() {
        parteCuerpo = nivel.parteCuerpo
        herramientaCorrecta = nivel.herramientaRequerida


         herramientas = listOf(
          Herramienta.RASQUETA_DURA,
             Herramienta.RASQUETA_BLANDA,
             Herramienta.CEPILLO_DURO,
             Herramienta.CEPILLO_BLANDO,
             Herramienta.ESCARBA_VASOS
        )

        if (herramientas.contains(herramientaCorrecta)) {
            println("La herramienta esta en la coleccion")
        }




    }

    private fun initView() {
        imgCaballo.setImageResource(parteCuerpo.imagenResId)
        //Dependiendo del nivel se muestran mas o menos
        herramienta_1.setImageResource(herramientaCorrecta.imagenResId)
        herramienta_1.visibility = View.VISIBLE
    }

}







