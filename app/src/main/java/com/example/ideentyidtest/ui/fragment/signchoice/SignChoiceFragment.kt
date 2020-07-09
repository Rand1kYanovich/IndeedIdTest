package com.example.ideentyidtest.ui.fragment.signchoice

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.R
import kotlinx.android.synthetic.main.fragment_sign_choice.*

class SignChoiceFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_choice


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignIn.setOnClickListener {
            requestPermissions(
                arrayOf(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                REQUEST_SIGN_IN_PERMISSION
            )
        }

        btnSignUp.setOnClickListener {
            requestPermissions(
                arrayOf(
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                REQUEST_SIGN_UP_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_SIGN_UP_PERMISSION) {
            if (grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED
                && grantResults[2] == PackageManager.PERMISSION_GRANTED
            ) {
                findNavController().navigate(R.id.action_signChoiceFragment_to_signUpFragment)
            }
        } else if (requestCode == REQUEST_SIGN_IN_PERMISSION) {
            if (grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
                findNavController().navigate(R.id.action_signChoiceFragment_to_signInFragment)
            }
        }
        return
    }

    companion object {
        private const val REQUEST_SIGN_UP_PERMISSION = 123
        private const val REQUEST_SIGN_IN_PERMISSION = 124
    }
}