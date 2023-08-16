package com.mybasecode.noteapp.presentation.modules.splash

import androidx.navigation.fragment.findNavController
import com.mybasecode.noteapp.databinding.FragmentSplashBinding
import com.mybasecode.noteapp.presentation.base.BaseMVVMFragment
import com.mybasecode.noteapp.presentation.modules.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseMVVMFragment<FragmentSplashBinding, SplashViewModel>() {
    override fun getViewModelClass(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    override fun getLayoutBinding(): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initialize() {
        getViewModel().navigateToHome()
    }

    override fun registerViewEvent() {
    }

    override fun registerViewModelObs() {
        getViewModel().navigateHomeObs.observe(this) {
            HomeFragment.navigateFromSplashScreen(findNavController())
        }
    }
}