package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.CadastroFragmentBinding
import com.google.firebase.auth.FirebaseAuth


class CadastroFragment : Fragment(R.layout.cadastro_fragment) {

    private lateinit var auth: FirebaseAuth
    private var _binding: CadastroFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        _binding = CadastroFragmentBinding.bind(view)

        requireActivity()
            .findViewById<View>(R.id.buttomNav_View)
            .visibility = View.GONE

        binding.txtLogin.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_homepageFrament)


        }


        val progressBarCadastro = binding.progressBarCadastro

        binding.btnRegister.setOnClickListener {


           val email = binding.edtEmail.text.toString().trim()
           val senha =  binding.edtPassword.text.toString().trim()
           val confirmSenha = binding.edtConfirmPassword.text.toString().trim()

            if( email.isEmpty() ){
                binding.tilEmail.error = "Digite seu E-mail"

            }
            else {
                binding.tilEmail.error = null
            }

            if ( senha.isEmpty() ){
                binding.tillSenha.error = "Digite sua Senha"
            }
            else {
                binding.tillSenha.error = null
            }
             if ( confirmSenha.isEmpty() ){
                binding.tillConSenha.error = "confirme sua Senha "
            }

            else {
                progressBarCadastro.visibility = View.VISIBLE
                auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "seu cadastro foi feito com Sucesso", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_cadastroFragment_to_home_screen)
                    }
                    else {
                        Toast.makeText(requireContext(), "erro: Usuário ou E-mail invalido ", Toast.LENGTH_SHORT).show()
                    }
                    progressBarCadastro.visibility = View.GONE
                }}


        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}