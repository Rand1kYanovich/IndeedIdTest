package com.example.ideentyidtest.ui.fragment.signup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.security.keystore.KeyProperties
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.R
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.viewmodel.signup.SignUpViewModel
import com.google.zxing.integration.android.IntentIntegrator
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.Key
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


class SignUpFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_up

    private var login = ""
    private var password = ""

    private val viewModel: SignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val integrator = IntentIntegrator.forSupportFragment(this)
        integrator.setOrientationLocked(true)
        integrator.setPrompt(getString(R.string.fragment_sign_up_promt))
        integrator.initiateScan()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isUserExist.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.user_exist_error),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        val contents = result.contents
        if (contents != null) {
            val authData = Base64.decode(contents, Base64.DEFAULT)
            val textAuthData = String(authData)
            val url = Uri.parse(textAuthData)

            login = url.getQueryParameter("login").toString()
            password = url.getQueryParameter("password").toString()

            viewModel.onSignUpBtnClick(login)
        } else {
            findNavController().popBackStack()
        }
    }
}