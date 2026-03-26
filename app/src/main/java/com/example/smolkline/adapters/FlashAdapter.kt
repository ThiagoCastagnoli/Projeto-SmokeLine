package com.example.smolkline.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Flash
import com.example.smolkline.Fragments.HomePageFramentsDirections
import com.example.smolkline.R

class FlashAdapter (
    private val listFlash: List<Flash>
) : RecyclerView.Adapter<FlashAdapter.FlashViewHolder>(){
    class FlashViewHolder( view : View): RecyclerView.ViewHolder(view){

        val cardV = itemView.findViewById<CardView>(R.id.cardFlash)
        val titulo: TextView = view.findViewById<TextView>(R.id.txtTitulo_Flash)
        val subtitulo: TextView = view.findViewById<TextView>(R.id.txtSubtitulo_Flash)
        val imag: ImageView = view.findViewById<ImageView>(R.id.imgFlash)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flash,parent, false )
        return FlashViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlashViewHolder, position: Int) {
        val item  = listFlash[position]
        holder.titulo.text = item.titulo
        holder.subtitulo.text = item.subTitulo
        holder.imag.setImageResource(item.image)
        holder.cardV.setOnClickListener {
            val action = HomePageFramentsDirections.actionHomeFragmentToVideoFlashFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }
    override fun getItemCount() = listFlash.size

}
