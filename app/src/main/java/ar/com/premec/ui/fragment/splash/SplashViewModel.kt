package ar.com.premec.ui.fragment.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

class SplashViewModel : ViewModel() {

    sealed class Resource<out R> {
        data class Success<out T>(val data: T) : Resource<T>()
        data class Error<out T>(val exception: Exception) : Resource<T>()
        class Loading<out T> : Resource<T>()
    }

    val appLoaded = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            //TODO simulate some work, I sleep the thread. It will be removed in the future.
            Thread.sleep(3000)
            emit(Resource.Success(true))
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }
}