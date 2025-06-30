package com.iegb.travel_peru.Modelo

data class Ubicacion(
    val id:Int=0,
    val nombre:String=""
){
    override fun toString(): String {
        return nombre
    }
}
