package ar.com.premec.ui.fragment.forms.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import ar.com.premec.data.FormDAO
import ar.com.premec.repository.FormsPagingSource

class FormListViewModel : ViewModel() {

    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 10)
    ) {
        //TODO The DAO should be injected by HILT
        FormsPagingSource(FormDAO(), "")
    }.flow
        .cachedIn(viewModelScope)
}