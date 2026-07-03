package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class ConfigurationFragment : Fragment(R.layout.configuration_fragment) {

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        val btnLogout = view.findViewById<Button>(R.id.sairdaconta)

        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {

        FirebaseAuth.getInstance().signOut()

        googleSignInClient.signOut().addOnCompleteListener {

            googleSignInClient.revokeAccess().addOnCompleteListener {

                Toast.makeText(
                    requireContext(),
                    "Logout realizado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                findNavController().navigate(R.id.action_configurationFragment_to_homepageFrament)
            }
        }
    }
}