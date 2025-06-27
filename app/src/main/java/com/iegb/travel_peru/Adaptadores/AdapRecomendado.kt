package com.iegb.travel_peru.Adaptadores

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.iegb.travel_peru.Modelo.Lugar
import com.iegb.travel_peru.databinding.VistaRecomendadoBinding

class AdapRecomendado(private val lugares:List<Lugar>):
RecyclerView.Adapter<AdapRecomendado.Viewholder>(){

    private lateinit var context: Context

    class Viewholder (val binding: VistaRecomendadoBinding):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapRecomendado.Viewholder {
        context = parent.context
        val binding = VistaRecomendadoBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: AdapRecomendado.Viewholder, position: Int) {
        val lugar = lugares[position]
        Glide.with(context)
            .load(lugar.imagenUrl)
            .into(holder.binding.img)

        holder.binding.txtTitulo.text = lugar.titulo
    }

    override fun getItemCount(): Int = lugares.size
}