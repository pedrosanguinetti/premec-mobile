package ar.com.premec.ui.fragment.forms.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.premec.databinding.FragmentFormsListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FormListFragment : Fragment() {

    private var _binding: FragmentFormsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FormListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormsListBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        val pagingAdapter = FormListAdapter(FormListAdapter.FormsComparator)
        binding.rvForms.layoutManager = LinearLayoutManager(requireContext())
        binding.rvForms.adapter = pagingAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}