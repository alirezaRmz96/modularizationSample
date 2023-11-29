package com.example.userUi

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.common.NavArguments
import com.example.common.collectOnFragment
import com.example.user.ui.databinding.FragmentUserBinding
import javax.inject.Inject


class UserFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<UserViewModel> { factory }
    private lateinit var binding: FragmentUserBinding

    private val userName: String? by lazy {
        arguments?.getString(NavArguments.userArgs)
    }


    override fun onAttach(context: Context) {
        provideInjector().inject(this)
        super.onAttach(context)
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

        viewModel.userToken.collectOnFragment(this) { token ->
            Toast.makeText(requireContext(), token, Toast.LENGTH_SHORT).show()
        }

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