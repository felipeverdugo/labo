package com.felipe.aprendamosalimpiar.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.felipe.aprendamosalimpiar.R
import com.felipe.aprendamosalimpiar.data.models.Dificultad
import com.felipe.aprendamosalimpiar.data.models.EstadoCaballo
import com.felipe.aprendamosalimpiar.data.models.Herramienta
import com.felipe.aprendamosalimpiar.data.models.NivelJuego
import com.felipe.aprendamosalimpiar.data.models.ParteCuerpo

class GameActivity : AppCompatActivity() {




    private lateinit var imgCaballo : ImageView

    private lateinit var herramienta_1 : ImageView
//    private lateinit var herramienta_2 : ImageView
//    private lateinit var herramienta_3 : ImageView
//    private lateinit var herramienta_4 : ImageView
//    private lateinit var herramienta_5 : ImageView


    private lateinit var mancha_1 : ImageView
    private lateinit var mancha_2 : ImageView
    private lateinit var mancha_3 : ImageView
    private lateinit var mancha_4 : ImageView


    private lateinit var estadoDelCaballo : EstadoCaballo
    private lateinit var dificultad : Dificultad
    private lateinit var nivel : NivelJuego
    private lateinit var parteCuerpo: ParteCuerpo
    private lateinit var herramientaCorrecta: Herramienta
//    private lateinit var herramientas : List<Herramienta>
    // lo que hace es un diccionario donde  tiene el id(mancha) y cantidad de veces que la herramienta pasa por la mancha
    private val contadorManchas = mutableMapOf<Int, Int>()
    private  var manchasLimpias: Int = 0


    private fun setLevelDefalut(){
        dificultad = Dificultad.FACIL
        nivel = NivelJuego.NIVEL_1
    }

    private fun setImageSaturation(imageView: ImageView, saturation: Float) {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(saturation)
        imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }



    private fun cambiarEstadoDelaMancha(imgMancha : ImageView) {
        if (imgMancha.imageAlpha > 50)
            imgMancha.imageAlpha -= 8

    }


    private fun cambiarEstadoDelCaballo(imgCaballo : ImageView,estado : EstadoCaballo) {
        when (estado) {

            EstadoCaballo.muySucio -> {
                imgCaballo.imageAlpha = 128
                setImageSaturation(imgCaballo, 0f)

            }

             EstadoCaballo.algoSucio-> {
                imgCaballo.imageAlpha = 150
                setImageSaturation(imgCaballo, 0.3f)

            }

            EstadoCaballo.limpio -> {
                imgCaballo.imageAlpha = 200
                setImageSaturation(imgCaballo, 0.6f)

            }
            EstadoCaballo.muyLimpio  -> {
                imgCaballo.imageAlpha = 255
                setImageSaturation(imgCaballo, 1f)


            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
        initComponents()
        initExtras()
        initPreGame()
        initView()
        initGame()


    }

    private fun initComponents() {


        imgCaballo = findViewById<ImageView>(R.id.imgCaballo)

        mancha_1 = findViewById<ImageView>(R.id.mancha1)
        mancha_2 = findViewById<ImageView>(R.id.mancha2)
        mancha_3 = findViewById<ImageView>(R.id.mancha3)
        mancha_4 = findViewById<ImageView>(R.id.mancha4)



        herramienta_1 = findViewById<ImageView>(R.id.herramienta1)
//        herramienta_2 = findViewById<ImageView>(R.id.herramienta2)
//        herramienta_3 = findViewById<ImageView>(R.id.herramienta3)
//        herramienta_4 = findViewById<ImageView>(R.id.herramienta4)
//        herramienta_5 = findViewById<ImageView>(R.id.herramienta5)


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
        estadoDelCaballo = EstadoCaballo.muySucio


//        herramientas = listOf(
//          Herramienta.RASQUETA_DURA,
//             Herramienta.RASQUETA_BLANDA,
//             Herramienta.CEPILLO_DURO,
//             Herramienta.CEPILLO_BLANDO,
//             Herramienta.ESCARBA_VASOS
//        )


    }

    private fun initView() {
        imgCaballo.setImageResource(parteCuerpo.imagenResId)
        //Dependiendo del nivel se muestran mas o menos
        //Usamos la herramienta 1 como la correcta
        herramienta_1.setImageResource(herramientaCorrecta.imagenResId)
        herramienta_1.visibility = View.VISIBLE
        cambiarEstadoDelCaballo(imgCaballo,EstadoCaballo.muySucio)
    }



    @SuppressLint("ClickableViewAccessibility")
    private fun initGame() {

        // Inicializa el contador para cada mancha en 0
        listOf(mancha_1, mancha_2, mancha_3, mancha_4).forEach { contadorManchas[it.id] = 0 }
        manchasLimpias = 0


        herramienta_1.setOnTouchListener(object : View.OnTouchListener {

            //Guardo la posicion inicial de la herramienta
            val posicionInicialHerramientaX = herramienta_1.x
            val posicionInicialHerramientaY = herramienta_1.y


            private var posicionHerramientaX = 0f
            private var posicionHerramientaY = 0f



            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        posicionHerramientaX = view.x - event.rawX
                        posicionHerramientaY = view.y - event.rawY
                        view.bringToFront()


                    }
                    MotionEvent.ACTION_MOVE -> {
                        // Cuando el usuario mueve se va actualizando la vista
                        view.x = event.rawX + posicionHerramientaX
                        view.y = event.rawY + posicionHerramientaY
                        verificarMovimiento(view) //Verifica si la herramienta esta pasando por la mancha


                    }
                    MotionEvent.ACTION_UP -> {
                        // Si el usuario suelta la herramienta vuelve a la posicion inicial
                        view.animate()
                            .x(posicionInicialHerramientaX)
                            .y(posicionInicialHerramientaY)
                            .setDuration(300) // Duración de la animación en milisegundos
                            .start()
                    }
                }
                return true
            }
        })
    }

    private fun verificarMovimiento(herramienta: View) {

        val manchas = listOf(mancha_1, mancha_2, mancha_3, mancha_4)

        for (mancha in manchas) {
            if (coincidenPuntos(herramienta, mancha)) {
                val idMancha = mancha.id

                contadorManchas[idMancha] = (contadorManchas[idMancha] ?: 0) + 1
                cambiarEstadoDelaMancha(mancha)

                if (contadorManchas[idMancha] == 100) {
                    // Se puede ajustar el numero para aumentar la dificultad o poner algo para desactivar la mancha luego de 2 seg para que el contador(numero) sea mas razonanble
                    estadoDelCaballo = estadoDelCaballo.limpiar()
                    cambiarEstadoDelCaballo(imgCaballo,estadoDelCaballo)
                    mancha.visibility = View.GONE
                    manchasLimpias += 1





                    if (manchasLimpias == 4) {
                        herramienta.animate().x(0F).y(0F)
                            .start()
                        pasarDeNivel()
                    }
                }


            }
        }
    }




    private fun coincidenPuntos(herramienta: View, mancha: ImageView): Boolean {
        val rect1 = intArrayOf(0, 0).also { herramienta.getLocationOnScreen(it) }
        val rect2 = intArrayOf(0, 0).also { mancha.getLocationOnScreen(it) }

        val x1 = rect1[0]
        val y1 = rect1[1]
        val ancho1 = herramienta.width
        val alto1 = herramienta.height

        val x2 = rect2[0]
        val y2 = rect2[1]
        val ancho2 = mancha.width
        val alto2 = mancha.height

        return x1 < x2 + ancho2 &&
                x1 + ancho1 > x2 &&
                y1 < y2 + alto2 &&
                y1 + alto1 > y2

    }



    private fun pasarDeNivel() {
        Log.i("","fgeosjgoerasjg")
        val intent = Intent(this, PasarNivel::class.java)
        intent.putExtra("MENSAJE", "¡Pasaste de nivel!")
        startActivity(intent)
    }

}







