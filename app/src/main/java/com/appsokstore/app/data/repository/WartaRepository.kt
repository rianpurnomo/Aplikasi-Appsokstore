package com.appsokstore.app.data.repository

import com.appsokstore.app.data.model.ActionState
import com.appsokstore.app.data.model.Warta
import com.appsokstore.app.data.remote.RetrofitApi
import com.appsokstore.app.data.remote.WartaService
import retrofit2.await
import java.lang.Exception

class WartaRepository {
    private val wartaService: WartaService by lazy { RetrofitApi.wartaService() }

    suspend fun listWarta(): ActionState<List<Warta>> {
        return try {
            val list = wartaService.listWarta().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailWarta(url: String): ActionState<Warta> {
        return try {
            val list = wartaService.detailWarta(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchWarta(query: String): ActionState<List<Warta>> {
        return try {
            val list = wartaService.searchWarta(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}