package com.example.ideentyidtest.ui.fragment.signin

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.ui.fragment.BaseFragment
import com.example.ideentyidtest.R
import com.example.ideentyidtest.viewmodel.signin.SignInViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.FileInputStream
import java.lang.Exception
import java.security.KeyStore
import javax.crypto.spec.SecretKeySpec


class SignInFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_in

    private val ks = KeyStore.getInstance(KeyStore.getDefaultType())
    private val viewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignIn.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()

            try {
                val ios = FileInputStream("${requireContext().filesDir}/keystore.keystore")
                ks.load(ios, getString(R.string.app_name).toCharArray())

                val protParam = KeyStore.PasswordProtection(login.toCharArray())
                val secretKey: KeyStore.SecretKeyEntry? = ks.getEntry(
                    getString(R.string.keystore_alias),
                    protParam
                ) as? KeyStore.SecretKeyEntry

                val secretKeyPassword = SecretKeySpec(password.toByteArray(), "PKCS12")
                val skEntry = KeyStore.SecretKeyEntry(secretKeyPassword)

                if (secretKey?.secretKey == skEntry.secretKey) {
                    findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                } else {
                    showToast(R.string.user_not_verified)
                }
            } catch (e: Exception) {
                showToast(R.string.user_not_exist_error)
            }

        }
    }

}

