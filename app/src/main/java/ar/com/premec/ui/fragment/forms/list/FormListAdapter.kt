package ar.com.premec.ui.fragment.forms.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.premec.data.model.Form
import ar.com.premec.databinding.ItemFormBinding
import ar.com.premec.ui.fragment.forms.list.FormListAdapter.FormViewHolder

class FormListAdapter(diffCallback: DiffUtil.ItemCallback<Form>) :
    PagingDataAdapter<Form, FormViewHolder>(diffCallback) {

    object FormsComparator : DiffUtil.ItemCallback<Form>() {

        override fun areItemsTheSame(oldItem: Form, newItem: Form): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Form, newItem: Form): Boolean {
            //TODO check property by property in the equal method to check if there was a data update.
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FormViewHolder {
        val binding: ItemFormBinding =
            ItemFormBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return FormViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        val item = getItem(position)
        //TODO Note that item may be null. ViewHolder must support binding a null item as a placeholder.)
        item?.let { holder.bind(it) }
    }

    class FormViewHolder(private val binding: ItemFormBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(form: Form) {
            binding.apply {
                lblId.text = form.id.toString()
                lblTitle.text = form.title
            }
        }
    }
}