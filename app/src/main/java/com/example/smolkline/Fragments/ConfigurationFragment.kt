package com.example.smolkline.Fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.privacysandbox.ads.adservices.appsetid.AppSetId
import com.example.smolkline.R
import com.example.smolkline.databinding.ConfigurationFragmentBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.example.smolkline.screens.ConfigurationScreen
import androidx.compose.ui.platform.ViewCompositionStrategy

class ConfigurationFragment : Fragment(R.layout.configuration_fragment) {

    private fun mudarIdioma(language: String) {
        val appLocale = LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

    private var _binding: ConfigurationFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var googleSignInClient: GoogleSignInClient

    private fun mostrarDialogIdioma() {

        val idiomas = arrayOf("Português", "English")

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.choose_the_language))
            .setItems(idiomas) { _, which ->

                when (which) {
                    0 -> mudarIdioma("pt-BR")
                    1 -> mudarIdioma("en")
                }
            }
            .show()
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding = ConfigurationFragmentBinding.bind(view)





        binding.composeView.apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
            )

            setContent {
                ConfigurationScreen(
                    onChangeLanguage = {
                        mostrarDialogIdioma()
                    },
                    onLogout = {
                        logout()
                    }
                )
            }
        }





        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)


    }

    private fun logout() {

        FirebaseAuth.getInstance().signOut()

        googleSignInClient.signOut().addOnCompleteListener {

            googleSignInClient.revokeAccess().addOnCompleteListener {

                Toast.makeText(
                    requireContext(),
                    getString(R.string.successfully_logged_out),
                    Toast.LENGTH_SHORT
                ).show()

                findNavController().navigate(R.id.action_configurationFragment_to_homepageFrament)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}