package com.example.ideentyidtest.ui.fragment.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.R
import kotlinx.android.synthetic.main.fragment_sign_in.*
import java.io.FileInputStream
import java.lang.Exception
import java.security.KeyStore


class SignInFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_in

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignIn.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()

            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
        }
    }
}

