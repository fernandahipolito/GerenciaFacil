package com.devmasterteam.tasks.login.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.devmasterteam.tasks.LoginNavigation
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding
    private val loginNavigation: LoginNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variáveis da classe

        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Layout
        setContentView(binding.root)

        // Eventos
        binding.buttonLogin.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)

        // Observadores
        observe()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
           loginViewModel.doLogin(
               email = binding.editEmail.text.toString(),
               password = binding.editPassword.text.toString())
        }
    }

    private fun observe() {
        loginViewModel.initLogin.observe(this) { response ->
            when (response) {
                is ResultState.Success -> startTaskFormActivity(this)
                is ResultState.Error -> showErrorMessage()
                else -> {}

            }
        }
        }
        private fun handleLogin() {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
        }

        private fun startTaskFormActivity(context: Context) {
            loginNavigation.goToFeature(context)
        }

        private fun showErrorMessage() {
            val text = "Opa, isso com certeza não deu certo!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
}



