package com.iegb.travel_peru.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.iegb.travel_peru.R
import com.iegb.travel_peru.VistaModelo.Main_VistaModelo
import com.iegb.travel_peru.databinding.ActivityMainBinding
import com.iegb.travel_peru.databinding.InicioActivityBinding

class InicioActivity : AppCompatActivity() {

    private lateinit var binding: InicioActivityBinding
    private val viewModel: Main_VistaModelo by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //agregado
        binding = InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modeloVistaObservacion()

        window.statusBarColor = Color.BLACK

        setContentView(R.layout.inicio_activity)
    }

    private fun modeloVistaObservacion() {
        viewModel.upcomingTrips.observe(this){
            list->
            binding.pbProximo.visibility =
                if(list.isEmpty())View.GONE else View.GONE
            binding.viewProximo.apply{
                layoutManager = LinearLayoutManager(
                    this@InicioActivity,
                    LinearLayoutManager.HORIZONTAL,false
                )
                //adapter =
            }
        }
    }
}