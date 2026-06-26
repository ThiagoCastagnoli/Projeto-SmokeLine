package com.example.smolkline.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Model.Mapas
import com.example.smolkline.R

class MapasAdapter(private val lista: List<Mapas>):
RecyclerView.Adapter<MapasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nome = view.findViewById<TextView>(R.id.txtMapName)
        val qtdSmoke = view.findViewById<TextView>(R.id.txtSmokeCount)
        val imagemMap = view.findViewById<ImageView>(R.id.imgMap)
        val imageLogo = view.findViewById<ImageView>(R.id.imgLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mapa_home, parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ){

        val item = lista[position]
        holder.nome.text = item.nome
        holder.qtdSmoke.text = item.qtdsmokes
        holder.imagemMap.setImageResource(item.imagemMap)
        holder.imageLogo.setImageResource(item.imagemIconMap)

    }

    override fun getItemCount() = lista.size

}
