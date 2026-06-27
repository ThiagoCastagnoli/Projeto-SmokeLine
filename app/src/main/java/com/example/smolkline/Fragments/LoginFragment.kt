package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.HomePageBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.home_page) {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    auth = FirebaseAuth.getInstance()
        _binding = HomePageBinding.bind(view)


        val google = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)





        binding.button.setOnClickListener {

            val loginEmail = binding.edtEmailLogin.text.toString().trim()
            val loginPassword = binding.edtLoginPassword.text.toString().trim()

            if (loginEmail.isEmpty()) {
                Toast.makeText(requireContext(), "digite seu email", Toast.LENGTH_SHORT).show()
            }
            else if (loginPassword.isEmpty()){

                Toast.makeText(requireContext(), "digite sua senha", Toast.LENGTH_SHORT).show()

            }
            else {
                auth.signInWithEmailAndPassword(loginEmail, loginPassword)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(requireContext(), "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_homepageFrament_to_home_screen)
                        }
                        else {
                            Toast.makeText(requireContext(), "email ou senha invalido ", Toast.LENGTH_SHORT).show()
                        }
                    }

            }
        }

        binding.txtRegister.setOnClickListener {
            findNavController().navigate(
                R.id.action_homePageFragment_to_cadastroFragment
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}