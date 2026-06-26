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

        binding.btnRegister.setOnClickListener {

           val usuario = binding.edtUsername.text.toString().trim()
           val email = binding.edtEmail.text.toString().trim()
           val senha =  binding.edtPassword.text.toString().trim()
           val confirmSenha = binding.edtConfirmPassword.text.toString().trim()

            if( email.isEmpty() ){
                Toast.makeText(requireContext(), "digite seu email", Toast.LENGTH_SHORT).show()

            }
            else if ( senha.isEmpty() ){
                Toast.makeText(requireContext(), "digite sua senha", Toast.LENGTH_SHORT).show()
            }
            else if ( confirmSenha.isEmpty() ){
                Toast.makeText(requireContext(), "confirme sua senha", Toast.LENGTH_SHORT).show()
            }
            else { auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "seu cadastro foi feito com Sucesso", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(requireContext(), "erro: Usuário ou E-mail invalido ", Toast.LENGTH_SHORT).show()
                    }
                }}

        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}