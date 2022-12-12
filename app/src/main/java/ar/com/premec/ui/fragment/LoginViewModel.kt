package ar.com.premec.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ar.com.premec.ui.fragment.utils.Result.Error
import ar.com.premec.ui.fragment.utils.Result.Loading
import ar.com.premec.ui.fragment.utils.Result.Success
import kotlinx.coroutines.Dispatchers

class LoginViewModel : ViewModel() {

    fun login(user: String, password: String) = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Loading())
        try {
            //TODO simulate some work, I sleep the thread. It will be removed in the future.
            Thread.sleep(5000)
            emit(Success(true))
        } catch (ex: Exception) {
            emit(Error(ex))
        }
    }
}