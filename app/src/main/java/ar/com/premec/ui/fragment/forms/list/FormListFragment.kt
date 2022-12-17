package ar.com.premec.ui.fragment.forms.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.premec.R
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        setupUI()
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                // Handle for example visibility of menu items
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_form_list, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.formsListFragment -> {
                        logOutDialog()
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun logOutDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setMessage(R.string.logout_title_messsage).setTitle(R.string.logout_title_dialog)
        builder.apply {
            setPositiveButton(
                R.string.yes
            ) { _, _ ->
                //TODO clean credentials
            }
            setNegativeButton(
                R.string.no
            ) { _, _ ->
            }
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
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