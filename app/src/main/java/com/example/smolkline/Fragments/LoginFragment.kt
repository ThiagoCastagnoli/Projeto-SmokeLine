package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.HomePageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import android.app.Activity

class LoginFragment : Fragment(R.layout.home_page) {


    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful){
                    Toast.makeText(
                        requireContext(),
                        "Login realizado com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_homepageFrament_to_home_screen)

                }
                else {
                    Toast.makeText(
                        requireContext(),
                        task.exception?.message ?: "Erro no login",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

    }



    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)

            }
            catch (e: ApiException){
                e.printStackTrace()
            }
        }
    }
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    auth = FirebaseAuth.getInstance()
        _binding = HomePageBinding.bind(view)



        val google = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), google)


        val progressBarLogin = binding.progressBarLogin
        val progressBarGoogle = binding.progressBarGoogle
        val buttonLogin = binding.button
        val buttonGoogle = binding.btnGoogle

        binding.button.setOnClickListener {


            val loginEmail = binding.edtEmailLogin.text.toString().trim()
            val loginPassword = binding.edtLoginPassword.text.toString().trim()


            if (loginEmail.isEmpty() ) {

                binding.tillEmailLog.error = getString(R.string.EnterYourEmail)

            }
            else {

                binding.tillEmailLog.error = null

            }
             if (loginPassword.isEmpty()){

                binding.tillSenhaLog.error = getString(R.string.EnterYourPassword)


                 progressBarLogin.visibility = View.GONE
                 buttonLogin.visibility = View.VISIBLE
            }

            else{

                binding.tillSenhaLog.error = null


                 progressBarLogin.visibility = View.VISIBLE
                 buttonLogin.visibility = View.GONE
                 auth.signInWithEmailAndPassword(loginEmail, loginPassword)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){

                            Toast.makeText(requireContext(), "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_homepageFrament_to_home_screen)

                        }

                        else {
                            progressBarLogin.visibility = View.VISIBLE
                            Toast.makeText(requireContext(), "email ou senha invalido ", Toast.LENGTH_SHORT).show()

                        }
                        progressBarLogin.visibility = View.GONE
                        buttonLogin.visibility = View.VISIBLE
                    }

            }
        }

        binding.devButton.setOnClickListener {
            findNavController().navigate(R.id.action_homepageFrament_to_home_screen)
        }


        binding.txtRegister.setOnClickListener {
            findNavController().navigate(
                R.id.action_homePageFragment_to_cadastroFragment
            )
        }
        binding.btnGoogle.setOnClickListener {
            progressBarGoogle.visibility = View.VISIBLE
            buttonGoogle.visibility = View.GONE


            val signInIntent = googleSignInClient.signInIntent
            launcher.launch(signInIntent)


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}