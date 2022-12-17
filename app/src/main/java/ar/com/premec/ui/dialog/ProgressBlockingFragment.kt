package ar.com.premec.ui.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import ar.com.premec.databinding.FragmentProgressBlockingBinding

class ProgressBlockingFragment : DialogFragment() {

    private var _binding: FragmentProgressBlockingBinding? = null
    private val binding get() = _binding!!

    companion object {

        internal val PROGRESS_DIALOG = "PROGRESS_DIALOG"

        fun newInstance(): DialogFragment {
            val dialog = ProgressBlockingFragment()
            dialog.isCancelable = false
            return dialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireDialog().window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _binding = FragmentProgressBlockingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        requireDialog().window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}