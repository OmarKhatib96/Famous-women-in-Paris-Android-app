package com.ismin.opendataapp.webservice



import com.ismin.opendataapp.Women


import retrofit2.Call
import retrofit2.http.GET

 interface RetrofitService {

    @GET(" ")
    fun findWomen():Call<List<Women>>
}


