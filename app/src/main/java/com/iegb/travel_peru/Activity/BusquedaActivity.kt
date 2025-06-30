package com.iegb.travel_peru.Activity

import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.disklrucache.DiskLruCache
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.iegb.travel_peru.Modelo.Ubicacion
import com.iegb.travel_peru.R
import com.iegb.travel_peru.databinding.ActivityBusquedaBinding
import java.text.SimpleDateFormat
import java.util.Locale

class BusquedaActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityBusquedaBinding
    private var pasajeroAdulto = 1
    private val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val calendario = Calendar.getInstance()
    var database: FirebaseDatabase?=null
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBusquedaBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()

        ubicacionInicio()
    }

    private fun ubicacionInicio() {
        binding.apply {
            progressBarDe.visibility= View.VISIBLE
            progressBarHacia.visibility= View.VISIBLE
            val myRef: DatabaseReference = database!!.getReference("Ubicaciones")
            val lista = ArrayList<Ubicacion>()
            myRef.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        for(issue in snapshot.children){
                            issue.getValue(Ubicacion::class.java)?.let { lista.add(it) }
                        }
                        val  adaptador = ArrayAdapter(
                            this@BusquedaActivity,
                            R.layout.busqueda_item,
                            lista
                        ).also {
                            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        }
                        binding.apply {
                            DeSp.adapter=adaptador
                            HaciaSp.adapter=adaptador
                            DeSp.setSelection(1)
                            progressBarDe.visibility= View.GONE
                            progressBarHacia.visibility= View.GONE
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}