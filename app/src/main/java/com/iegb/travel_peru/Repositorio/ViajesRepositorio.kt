package com.iegb.travel_peru.Repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.iegb.travel_peru.Modelo.Viaje
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.iegb.travel_peru.Modelo.Lugar


class ViajesRepositorio {
    private val database = FirebaseDatabase.getInstance().reference

    fun proximosViajes(): LiveData<List<Viaje>>{
        val data = MutableLiveData<List<Viaje>>()
        database.child("Viajes")
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = snapshot.children.mapNotNull { it.getValue(Viaje::class.java) }
                    data.postValue(list)
                }

                override fun onCancelled(error: DatabaseError) {
                    data.postValue(emptyList())
                }
            })
        return  data
    }

    fun getLugaresRecomendados(): LiveData<List<Lugar>>{
        val data = MutableLiveData<List<Lugar>>()
        database.child("LugaresRecomendados")
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = snapshot.children.mapNotNull { it.getValue(Lugar::class.java) }
                    data.postValue(list)
                }

                override fun onCancelled(error: DatabaseError) {
                    data.postValue(emptyList())
                }
            })
        return  data
    }
}