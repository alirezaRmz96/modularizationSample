package com.example.loginUi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.common.collectOnFragment
import com.example.login.ui.R
import javax.inject.Inject


class LoginFragment : Fragment() {

    @Inject
    lateinit var factory:ViewModelProvider.Factory

    private val viewModel by viewModels<LoginViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.collectOnFragment(this){
            when(it){
                is ViewState.Error -> TODO()
                ViewState.Loading -> TODO()
                is ViewState.Success<*> -> TODO()
            }
        }
    }
}