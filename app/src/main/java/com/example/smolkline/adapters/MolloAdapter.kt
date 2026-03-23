package com.example.smolkline.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Mollo
import com.example.smolkline.Fragments.HomePageFramentsDirections
import com.example.smolkline.R

class MolloAdapter(
    private val listaMollo: List<Mollo>
) : RecyclerView.Adapter<MolloAdapter.MolloViewHolder>(){

    class MolloViewHolder(view: View): RecyclerView.ViewHolder(view){

        val card = itemView.findViewById<CardView>(R.id.cardMollo)
        val titulo: TextView = view.findViewById<TextView>(R.id.txtTitulo_Mollo)
        val subTitulo: TextView = view.findViewById<TextView>(R.id.txtSubtitulo_Mollo)
        val image: ImageView = view.findViewById<ImageView>(R.id.imgMollo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MolloViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mollo, parent, false )
       return MolloViewHolder(view)
    }

    override fun onBindViewHolder(holder: MolloViewHolder, position: Int) {
        val item = listaMollo[position]
        holder.titulo.text = item.titulo
        holder.subTitulo.text = item.subTitulo
        holder.image.setImageResource(item.image)
        holder.card.setOnClickListener {
            val action = HomePageFramentsDirections.actionHomeFragmentToVideoFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = listaMollo.size






}


