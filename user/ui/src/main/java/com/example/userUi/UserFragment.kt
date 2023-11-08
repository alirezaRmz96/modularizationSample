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
import androidx.navigation.fragment.findNavController
import com.example.common.collectOnFragment
import com.example.user.ui.databinding.FragmentUserBinding
import javax.inject.Inject


class UserFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<UserViewModel> { factory }
    private lateinit var binding: FragmentUserBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        provideInjector().inject(this, viewLifecycleOwner)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userData.collectOnFragment(this) {

        }
        viewModel.viewState.collectOnFragment(this) {
            when (it) {
                is ViewState.Error -> Log.d("messi", "Error: ${it.message}")
                ViewState.Loading -> Log.d("messi", "Loading ")
                is ViewState.Success -> {
                    binding.check = "Simple awful app"
                }
            }
        }
    }
}