package com.example.ideentyidtest.ui.fragment.signchoice

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.R
import kotlinx.android.synthetic.main.fragment_sign_choice.*
import java.security.Permission
import java.util.jar.Manifest

class SignChoiceFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_choice


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signChoiceFragment_to_signInFragment)
        }

        btnSignUp.setOnClickListener {
            requestPermissions(
                arrayOf(android.Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            findNavController().navigate(R.id.action_signChoiceFragment_to_signUpFragment)
        }
        return
    }

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 123
    }
}