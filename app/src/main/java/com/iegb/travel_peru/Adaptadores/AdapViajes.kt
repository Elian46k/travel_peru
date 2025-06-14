package com.iegb.travel_peru.Adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import com.bumptech.glide.Glide
import com.iegb.travel_peru.Modelo.Viaje
import com.iegb.travel_peru.databinding.VistaViajeBinding

class AdapViajes (private val viajes: List<Viaje>)
    :RecyclerView.Adapter<AdapViajes.Viewholder>() {

        private lateinit var context: Context

    class Viewholder(val binding: VistaViajeBinding):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapViajes.Viewholder {
        context = parent.context
        val binding = VistaViajeBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: AdapViajes.Viewholder, position: Int) {
        val viaje = viajes[position]
        Glide.with(context)
            .load(viaje.logoCompania)
            .into(holder.binding.logo)

        holder.binding.txtCompania.text = viaje.nombreCompania
        holder.binding.txtDe.text = viaje.origen
        holder.binding.txtLugarOrigen.text = viaje.origenCodigo
        holder.binding.atxt.text = viaje.destino
        holder.binding.txtDestino.text = viaje.codigoDestino
        holder.binding.txtDuracionVuelo.text = viaje.duracionVuelo
        holder.binding.txtPuntuacion.text = viaje.puntaje.toString()
        holder.binding.txtPrecio.text = "S/.${viaje.precio}"
    }

    override fun getItemCount(): Int = viajes.size
}