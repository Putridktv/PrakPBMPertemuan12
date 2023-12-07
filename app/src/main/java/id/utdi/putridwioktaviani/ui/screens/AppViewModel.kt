package id.utdi.putridwioktaviani.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.utdi.putridwioktaviani.network.AppApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AppUiState {
    data class Success(val photos: String) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}

var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
    private set

class AppViewModel : ViewModel() { //bagian view model untuk megelola data yang akan ditampilkan dengan state yang diperoleh dari internet dengan retrofit
    var appUiState: String by mutableStateOf("")
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = AppApi.retrofitService.getPhotos()
                appUiState = listResult
            } catch (e: IOException) {

            }
        }
    }
}