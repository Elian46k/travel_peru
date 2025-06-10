package com.iegb.travel_peru.Modelo

data class Viaje(
    val logoCompania: String = "",
    val nombreCompania: String = "",
    val duracionVuelo: String = "",
    val fecha: String = "",
    val origen: String = "",
    val origenCodigo: String = "",
    val precio: Double = 0.0,
    val horaSalida: String = "",
    val destino: String = "",
    val puntaje: Double = 0.0,
    val codigoDestino: String = ""
)
