package com.example.smolkline.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Smolk
import com.example.smolkline.Fragments.HomePageFramentsDirections
import com.example.smolkline.Fragments.SmokesFragment
import com.example.smolkline.R

 class SmolkAdapter(
    private val listaSmolk: List<Smolk>
) : RecyclerView.Adapter<SmolkAdapter.SmolkViewHolder>() {

    class SmolkViewHolder(view: View): RecyclerView.ViewHolder(view){

        val card = itemView.findViewById<CardView>(R.id.cardSmolk)
        val titulo: TextView =  view.findViewById<TextView>(R.id.txtTitulo)
        val subTitulo: TextView = view.findViewById<TextView>(R.id.txtSubtitulo)
        val imagem: ImageView = view.findViewById<ImageView>(R.id.imgSmoke)

    }

    // cria cada item visual da lista/ cria o card
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmolkViewHolder {
        val view = LayoutInflater.from(parent.context) //<-- transforma uma View em um SmolkViewHolder
            .inflate(R.layout.item_smoke, parent, false ) // <-- pega o item/ false = recyclerview faz sozinho
        return SmolkViewHolder(view) // <-- entraga a view para o ViewHOlder

    }
    // coloca os dadods no card
    override fun onBindViewHolder(holder: SmolkViewHolder, position: Int) {
        val item = listaSmolk[position] // <-- pega o item da posição
        holder.titulo.text = item.titulo // <-- coloca o titulo dentro do TextView
        holder.subTitulo.text = item.subTitulo
        holder.imagem.setImageResource(item.imagem) // <-- coloca a Imagem
        holder.card.setOnClickListener {
            val action = HomePageFramentsDirections.actionHomeFragmentToVideoFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = listaSmolk.size


}