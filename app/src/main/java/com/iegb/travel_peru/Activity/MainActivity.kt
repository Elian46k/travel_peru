package com.iegb.travel_peru.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.iegb.travel_peru.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val imagenes = listOf(
        R.drawable.ciudad_hz,
        R.drawable.parque_lama,
        R.drawable.fondo02_soledad_iglesia_huaraz,
        R.drawable.fondo03_senorita_hz,
        R.drawable.fondo04_vinicunca_cusco,
        R.drawable.fondo05_laguna_hz,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.TRANSPARENT
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        setContentView(R.layout.activity_main)

        val VisorImagen = findViewById<ImageView>(R.id.Visor_de_Fondo)
        val imagenAleatoria = imagenes[Random.nextInt(imagenes.size)]
        VisorImagen.setImageResource(imagenAleatoria)

        val BtnEmpezar: Button = findViewById(R.id.btnEmpezar)

        BtnEmpezar.setOnClickListener {
            val intent = Intent(applicationContext, InicioActivity::class.java)
            startActivity(intent)
        }
    }
}