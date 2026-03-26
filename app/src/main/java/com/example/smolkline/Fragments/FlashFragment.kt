package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Flash
import com.example.smolkline.R
import com.example.smolkline.adapters.FlashAdapter

public class FlashFragment: Fragment(R.layout.flash_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerFlash = view.findViewById<RecyclerView>(R.id.recyclerFlash)
        val list = listOf(
            Flash("flash meio", "flash Do janelão p/ Meio", R.drawable.flash_icoon),
            Flash("flash ct", "flash Do ct p/ tr", R.drawable.flash_icoon),
            Flash("flash B", "flash Da B p/ ct", R.drawable.flash_icoon),
            Flash("flash A", "flash Da A p/ Meio", R.drawable.flash_icoon),
            Flash("flash jungle", "flash Do jungle p/ A", R.drawable.flash_icoon)

        )
        recyclerFlash.layoutManager = LinearLayoutManager(view.context)
        recyclerFlash.adapter = FlashAdapter(list)
    }
}