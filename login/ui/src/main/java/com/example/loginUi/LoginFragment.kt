package com.example.loginUi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.collectOnFragment
import com.example.login.ui.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel> { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LoginInjector).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel

        initValue()
        initCollections()

    }

    private fun initValue() {
        binding.login.setOnClickListener {
            lifecycleScope.launch {
                viewModel.loginUser()
            }
        }
    }

    private fun initCollections() {
        viewModel.viewState.collectOnFragment(this) {
            when (it) {
                is ViewState.Error -> Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_SHORT
                ).show()

                ViewState.Loading -> binding.pbLogin.visibility = View.VISIBLE
                is ViewState.Success -> {
                    binding.pbLogin.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Login Correctly",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {}
            }
        }
    }
}