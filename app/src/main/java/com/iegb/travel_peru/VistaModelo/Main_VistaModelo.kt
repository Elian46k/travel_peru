package com.iegb.travel_peru.VistaModelo

import  androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.iegb.travel_peru.Modelo.Lugar
import com.iegb.travel_peru.Modelo.Viaje
import com.iegb.travel_peru.Repositorio.ViajesRepositorio

class Main_VistaModelo : ViewModel(){
    private val repositorio: ViajesRepositorio = ViajesRepositorio()
    val upcomingTrips: LiveData<List<Viaje>> = repositorio.proximosViajes()
    val recomendedPlaces: LiveData<List<Lugar>> = repositorio.getLugaresRecomendados()
}
