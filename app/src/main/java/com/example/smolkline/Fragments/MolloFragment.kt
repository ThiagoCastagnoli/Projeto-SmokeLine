package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smolkline.Classes.Mollo
import com.example.smolkline.R
import com.example.smolkline.adapters.MolloAdapter

public class MolloFragment: Fragment(R.layout.mollo_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerMollo = requireView().findViewById<RecyclerView>(R.id.recyclerMollo)

        val list = listOf(
            Mollo("Mollo Areia", "Mollo Caverna p/ areia", R.drawable.mollotov_icon),
            Mollo("Mollo B", "mollo bomb b miragem", R.drawable.mollotov_icon),
            Mollo("Mollo CT", "Mollo base ct", R.drawable.mollotov_icon),
            Mollo("Mollo Banana", "mollar banana", R.drawable.mollotov_icon)
        )

        recyclerMollo.layoutManager = LinearLayoutManager(view.context)
        recyclerMollo.adapter = MolloAdapter(list)
    }
}