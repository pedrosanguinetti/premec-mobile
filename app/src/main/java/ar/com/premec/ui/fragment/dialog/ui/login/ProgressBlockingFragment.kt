package ar.com.premec.ui.fragment.dialog.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.com.premec.R

class ProgressBlockingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //TODO add view binding
        return inflater.inflate(R.layout.fragment_progress_blocking, container, false)
    }
}