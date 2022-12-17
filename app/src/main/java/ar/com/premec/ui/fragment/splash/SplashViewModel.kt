package ar.com.premec.ui.fragment.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ar.com.premec.ui.fragment.utils.Result
import kotlinx.coroutines.Dispatchers

class SplashViewModel : ViewModel() {

    val appLoaded = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Result.Loading())
        try {
            //TODO simulate some work, I sleep the thread. It will be removed in the future.
            Thread.sleep(500)
            emit(Result.Success(true))
        } catch (ex: Exception) {
            emit(Result.Error(ex))
        }
    }
}