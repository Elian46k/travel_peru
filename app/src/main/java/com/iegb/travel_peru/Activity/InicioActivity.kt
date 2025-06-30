package com.iegb.travel_peru.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.iegb.travel_peru.Adaptadores.AdapRecomendado
import com.iegb.travel_peru.Adaptadores.AdapViajes
import com.iegb.travel_peru.VistaModelo.Main_VistaModelo
import com.iegb.travel_peru.databinding.InicioActivityBinding
import com.iegb.travel_peru.Activity.BusquedaActivity

class InicioActivity : AppCompatActivity() {

    private lateinit var binding: InicioActivityBinding
    private val viewModel: Main_VistaModelo by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modeloVistaObservacion()

        configurarEscuchaCategorias()
        
        window.statusBarColor = Color.BLACK
    }

    private fun configurarEscuchaCategorias() {
        binding.cat1.setOnClickListener {
            val intent = Intent(this, BusquedaActivity::class.java)
            intent.putExtra("categoria", "1")
            startActivity(intent) }
    }

    private fun modeloVistaObservacion() {
        viewModel.upcomingTrips.observe(this) { list ->
            binding.pbProximo.visibility =
                if (list.isEmpty()) View.VISIBLE else View.GONE

            binding.viewProximo.apply {
                layoutManager = LinearLayoutManager(
                    this@InicioActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = AdapViajes(list)
            }
        }

        viewModel.recomendedPlaces.observe(this) {list->
            binding.pbRecomendado.visibility= View.GONE

            binding.viewRecomendado.apply {
                layoutManager = LinearLayoutManager(
                    this@InicioActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = AdapRecomendado(list)
            }
        }
    }
}
