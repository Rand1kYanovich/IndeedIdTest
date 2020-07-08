package com.example.ideentyidtest.ui.fragment.signin

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.R
import kotlinx.android.synthetic.main.fragment_sign_in.*


class SignInFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_sign_in


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
        }
    }
}

