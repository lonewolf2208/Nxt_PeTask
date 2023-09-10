package com.example.nxtpetask.repo

import com.example.nxtpetask.model.PageDetails
import com.example.nxtpetask.network.Api
import com.example.nxtpetask.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MandatoryRepo @Inject constructor(
    private val api: Api,
) {
    fun getData(): Flow<Resource<PageDetails>> =  flow{
            emit(Resource.Loading())
            val data=api.getDetails()
            emit(Resource.Success(data=data))
    }.catch {
        emit(Resource.Error(it.message.toString()),)
    }
}