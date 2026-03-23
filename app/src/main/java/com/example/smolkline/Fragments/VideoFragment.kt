package com.example.smolkline.Fragments

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.smolkline.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class VideoFragment: Fragment(R.layout.videos_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.buttomNav_View)
        bottomNav.visibility = View.GONE

        val videoView = view.findViewById<VideoView>(R.id.videoView2)
        val videoPath = "android.resource://${requireContext().packageName}/${R.raw.smoke_cabe}"
        val uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)

        val controladorDeMidia = MediaController(requireContext())
        controladorDeMidia.setAnchorView(videoView)

        videoView.setMediaController(controladorDeMidia)
    }
}
