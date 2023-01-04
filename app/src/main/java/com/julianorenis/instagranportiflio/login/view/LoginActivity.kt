package com.julianorenis.instagranportiflio.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.julianorenis.instagranportiflio.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
        val editPassword = findViewById<TextInputEditText>(R.id.login_edit_password)

        editEmail.addTextChangedListener(watcher)
        editPassword.addTextChangedListener(watcher)

        findViewById<Button>(R.id.login_btn_enter).setOnClickListener {
        findViewById<TextInputLayout>(R.id.login_edit_email_input)
            .error = "Esse e-mail é inválido"

        findViewById<TextInputLayout>(R.id.login_edit_password_input)
            .error = "Senha incorreta"
        }

    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                findViewById<Button>(R.id.login_btn_enter).isEnabled = p0.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {

        }
    }
}