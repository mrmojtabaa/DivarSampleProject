package com.mojtabahd.divar

import com.mojtabahd.divar.entitiy.DivarSearchRequest
import com.mojtabahd.divar.entitiy.SearchResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DivarApiService {
    @POST("v8/search/1/ROOT")
    fun search(@Body divarSearchRequest: DivarSearchRequest?): Call<SearchResponse?>?
}