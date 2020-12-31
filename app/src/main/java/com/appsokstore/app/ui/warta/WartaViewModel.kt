package com.appsokstore.app.ui.warta

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsokstore.app.data.model.ActionState
import com.appsokstore.app.data.model.Warta
import com.appsokstore.app.data.repository.WartaRepository
import kotlinx.coroutines.launch

class WartaViewModel : ViewModel() {
    private val repo: WartaRepository by lazy { WartaRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Warta>>()
    val detailResp = MutableLiveData<Warta>()
    val searchResp = MutableLiveData<List<Warta>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listWarta() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listWarta()

            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailWarta(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailWarta(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchWarta(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchWarta(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}