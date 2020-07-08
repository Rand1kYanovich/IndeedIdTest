package com.example.ideentyidtest.ui.fragment.signup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.R
import com.example.ideentyidtest.ui.BaseFragment
import com.google.zxing.integration.android.IntentIntegrator


class SignUpFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_up

    val test = "c3VwZXI6Ly9zZWN1cmUvcGFnZT9sb2dpbj1hZG1pbiZwYXNzd29yZD1QQHNzdzByZA== "

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

        val auth = Base64.decode(test, Base64.DEFAULT)
        val text = String(auth)
        val url = Uri.parse(text)
        Log.e("BaseText", text)
        Log.e("BaseUrl", url.getQueryParameter("login").toString())
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        val contents = result.contents
        if (contents != null) {
            val authData = Base64.decode(contents, Base64.DEFAULT)
            val textAuthData = String(authData)
            val url = Uri.parse(textAuthData)
            Log.e("BaseText", textAuthData)
            Log.e("BaseUrl", url.getQueryParameter("login").toString())
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        } else {
            findNavController().popBackStack()
        }
    }
}