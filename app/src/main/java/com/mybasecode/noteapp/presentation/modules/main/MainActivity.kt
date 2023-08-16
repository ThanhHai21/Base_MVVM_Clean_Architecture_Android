package com.mybasecode.noteapp.presentation.modules.main

import com.mybasecode.noteapp.databinding.ActivityMainBinding
import com.mybasecode.noteapp.presentation.base.BaseMVVMActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseMVVMActivity<ActivityMainBinding, MainViewModel>() {
    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initialize() {
    }

    override fun registerViewEvent() {
    }

    override fun registerViewModelObs() {
    }
}