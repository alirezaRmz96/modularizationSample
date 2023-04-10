package com.example.userUi

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.common.collectOnFragment
import com.example.user.ui.R
import javax.inject.Inject


class UserFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<UserViewModel> { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as UserInjector).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userData.collectOnFragment(this) {
            Log.d("messi", "userData: $it")
        }
        viewModel.viewState.collectOnFragment(this) {
            when(it){
                is ViewState.Error -> Log.d("messi", "Error: ${it.message}")
                ViewState.Loading -> Log.d("messi", "Loading ")
            }
        }
    }
}