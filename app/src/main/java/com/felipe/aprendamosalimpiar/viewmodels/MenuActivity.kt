package com.felipe.aprendamosalimpiar.viewmodels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.felipe.aprendamosalimpiar.R
import com.felipe.aprendamosalimpiar.models.Dificultad
import com.felipe.aprendamosalimpiar.models.NivelJuego


class MenuActivity : AppCompatActivity() {
    private lateinit var dificultad: Dificultad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnJugar = findViewById<Button>(R.id.btnJugar)
        val btnConfigurar = findViewById<Button>(R.id.btnConfigurar)

        btnJugar.setOnClickListener {
            val intent = Intent(this, PreLevelActivity::class.java)
            dificultad = Dificultad.FACIL
            intent.putExtra("EXTRA DIFICULTAD",dificultad.name)
            intent.putExtra("EXTRA NIVEL",NivelJuego.NIVEL_1.name)
            startActivity(intent)

        }

        btnConfigurar.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            // habria que hacer como una variable global que conecte con la activity de config
            startActivity(intent)


        }
    }




}