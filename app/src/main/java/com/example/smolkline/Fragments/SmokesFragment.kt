package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Smolk
import com.example.smolkline.adapters.SmolkAdapter
import com.example.smolkline.R

 public class SmokesFragment:  Fragment (R.layout.smokes_fragment) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
   super.onViewCreated(view, savedInstanceState)

   val recyclerSmoke = requireView().findViewById<RecyclerView>(R.id.recyclerSmolk)




   val lista = listOf(
    Smolk("Bomb B Smolk Miragem", "Smolk CT", R.drawable.smolk_icon),
    Smolk("Bomb A Smolk", "Smolk Cabecinha", R.drawable.cabecinha)
   )

   recyclerSmoke.layoutManager = LinearLayoutManager(view.context)
   recyclerSmoke.adapter = SmolkAdapter(lista)




  }



}