package ar.com.premec.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ar.com.premec.databinding.FragmentLoginBinding
import ar.com.premec.ui.fragment.dialog.ui.login.ProgressBlockingFragment
import ar.com.premec.ui.fragment.utils.Result

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()
    private val progress by lazy {
        ProgressBlockingFragment.newInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {

        binding.btnLogin.setOnClickListener {
            //TODO pass user and pass from the textfields
            viewModel.login("Test", "Pass").observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Result.Loading -> {
                        progress.show(
                            childFragmentManager,
                            ProgressBlockingFragment.PROGRESS_DIALOG
                        )
                    }
                    is Result.Success -> {
                        progress.dismiss()
                    }
                    is Result.Error -> {
                        progress.dismiss()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}