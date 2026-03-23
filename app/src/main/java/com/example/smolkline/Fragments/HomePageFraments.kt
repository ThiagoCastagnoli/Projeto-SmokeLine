package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R

public class HomePageFraments: Fragment(R.layout.home_page){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)



        val button = view.findViewById<Button>(R.id.button)


        button.alpha = 0f
        button.animate()
            .translationY(8f)
            .setDuration(200)
            .withEndAction {
                button.animate().translationY(0f)
                    .setDuration(200)
            }
        button.animate()
            .alpha(1f)
            .setDuration(2000)
            .start()

        button.setOnClickListener {
            it.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(80)
                .withEndAction {
                    it.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(80)
                        .start()


                    findNavController().navigate(R.id.action_homepageFrament_to_home_screen)
                }
                .start()
        }


    }


}