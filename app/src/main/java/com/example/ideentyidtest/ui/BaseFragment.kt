package com.example.ideentyidtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    /**
     * @return true if activity need handle on onBackPressed() callback
     */
    open fun onBackPressed(): Boolean {
        return false
    }

    /**
     * Show toast in one line
     *
     * @param textId = show text id in res
     */
    fun showToast(textId: Int) {
        Toast.makeText(
            requireContext(),
            getString(textId),
            Toast.LENGTH_SHORT
        ).show()
    }

}