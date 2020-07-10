package com.example.ideentyidtest.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.ideentyidtest.ui.fragment.BaseFragment
import com.example.ideentyidtest.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager
            .findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment? ?: return
        val navController = navHost.navController
        bottomMenu.setupWithNavController(navController)
    }
}

