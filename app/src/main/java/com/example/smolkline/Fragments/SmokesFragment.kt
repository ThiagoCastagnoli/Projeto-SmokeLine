package com.example.smolkline.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smolkline.Model.Mapas
import com.example.smolkline.Model.Smolk
import com.example.smolkline.R
import com.example.smolkline.adapters.MapasAdapter
import com.example.smolkline.adapters.BannerAdapter
import com.example.smolkline.adapters.SmolkAdapter
import com.example.smolkline.databinding.SmokesFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class SmokesFragment : Fragment(R.layout.smokes_fragment) {

 private val handler = Handler(Looper.getMainLooper())
 private var currentPage = 0

 private val bannerRunnable = object : Runnable {
  override fun run() {
   if (_binding == null) return

   val adapter = binding.viewPagerBanner.adapter ?: return
   val total = adapter.itemCount

   if(total == 0 ) return

   binding.viewPagerBanner.setCurrentItem(currentPage, true)
   currentPage = (currentPage + 1 ) % total

   handler.postDelayed(this, 3000)
  }
 }

 private var _binding: SmokesFragmentBinding? = null
 private val binding get() = _binding!!

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  _binding = SmokesFragmentBinding.bind(view)

  val lista = listOf(
   Smolk(
    "Bomb B Smolk Miragem",
    "Smolk CT",
    R.drawable.smolk_icon
   ),

   Smolk(
    "Bomb A Smolk",
    "Smolk Cabecinha",
    R.drawable.cabecinha
   )
  )

  val bottomNav =
   requireActivity().findViewById<BottomNavigationView>(R.id.buttomNav_View)

  binding.txtVerTodos.setOnClickListener {

   bottomNav.selectedItemId = R.id.mapasFragment

  }

  binding.recyclerSmolk.layoutManager =
   LinearLayoutManager(requireContext())

  binding.recyclerSmolk.adapter =
   SmolkAdapter(lista)

   val listaBanners = listOf(
    R.drawable.bannernew,
    R.drawable.mirabanner,
    R.drawable.miragebanner,
    R.drawable.viewbanner2,
    R.drawable.bannernew,
    R.drawable.infbanner


   )
  binding.viewPagerBanner.adapter = BannerAdapter(listaBanners)
  handler.postDelayed(bannerRunnable, 2000)



  val recyclerMaps = binding.recyclerMaps
  val listaMapas = listOf(
   Mapas("Mirage", "20 smokes", R.drawable.img_mirage, R.drawable.logo_mirage),
   Mapas("Dust_2", "20 Smokes", R.drawable.map_dust, R.drawable.logo_dust),
   Mapas("Inferno", "20 Smokes", R.drawable.map_inf, R.drawable.logo_inf),
   Mapas("Nuke", "20 Smokes", R.drawable.mapa_nuke, R.drawable.logo_nuke,),
   Mapas("Overpass", "20 Smokes", R.drawable.map_over, R.drawable.logo_over),
   Mapas("Anubis", "20 Smokes", R.drawable.map_anubis, R.drawable.logo_anubis),
   Mapas("Ancient", "20 Smokes", R.drawable.map_ansient, R.drawable.logo_ancient),
   Mapas("cache", "20 Smokes", R.drawable.map_cahce, R.drawable.logo_cache)
  )
  binding.recyclerMaps.layoutManager =
   LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
  recyclerMaps.adapter = MapasAdapter(listaMapas)
  binding.recyclerMaps.isNestedScrollingEnabled = false

 }


 override fun onDestroyView() {
  super.onDestroyView()
  handler.removeCallbacks(bannerRunnable)
  _binding = null
 }
}


