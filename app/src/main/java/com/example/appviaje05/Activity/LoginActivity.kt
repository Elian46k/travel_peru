package com.example.appviaje05.Activity

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appviaje05.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var animatedBackground: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeViews()
        setupListeners()
        startBackgroundAnimation()
    }

    private fun initializeViews() {
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        animatedBackground = findViewById(R.id.animatedBackground)
    }

    private fun startBackgroundAnimation() {
        val animationDrawable = animatedBackground.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()
    }

    private fun setupListeners() {
        btnLogin.setOnClickListener {
            if (validateInputs()) {
                performLogin()
            }
        }

        findViewById<TextView>(R.id.tvRegister).setOnClickListener {
            // Aquí puedes navegar a la pantalla de registro
            // startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (email.isEmpty()) {
            tilEmail.error = "El correo electrónico es requerido"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = "Ingrese un correo electrónico válido"
            isValid = false
        } else {
            tilEmail.error = null
        }

        if (password.isEmpty()) {
            tilPassword.error = "La contraseña es requerida"
            isValid = false
        } else if (password.length < 6) {
            tilPassword.error = "La contraseña debe tener al menos 6 caracteres"
            isValid = false
        } else {
            tilPassword.error = null
        }

        return isValid
    }

    private fun performLogin() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Aquí implementarías la lógica de autenticación
        // Por ejemplo, usando Firebase Auth o tu propio backend
        
        // Por ahora, solo mostraremos un mensaje de éxito
        Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
        
        // Después de un login exitoso, navegar a la pantalla principal
        // startActivity(Intent(this, MainActivity::class.java))
        // finish()
    }
} 