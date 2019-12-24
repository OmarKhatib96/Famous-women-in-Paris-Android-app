package com.ismin.opendataapp.webservice
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.ismin.opendataapp.Women
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


internal class WomanWebService {
    private val women = ArrayList<Women>()
    private lateinit var womenWebService: RetrofitService


    fun getWomen(): ArrayList<Women>{

        return women
    }

    fun gettingDatafromServer():ArrayList<Women>{

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        womenWebService = retrofit.create(RetrofitService::class.java)
        return  serverCommunication()

    }

    private fun serverCommunication() : ArrayList<Women>{
        womenWebService.findWomen()
            .enqueue(object : Callback<List<Women>> {
                override fun onResponse(
                    call: Call<List<Women>>,
                    response: Response<List<Women>>
                ) {
                    val serverWomen = response.body()
                    if (serverWomen != null) {
                        women.clear()
                        women.addAll(serverWomen)
                        Log.d("No problems", "good")
                    }
                }

                override fun onFailure(
                    call: Call<List<Women>>,
                    t: Throwable
                ) {
                    Log.d("problem", t.toString())
                }


            })
        return women


    }


    companion object {
        private const val BASE_URL =
            "https://opendata.paris.fr/explore/dataset/femmes-illustres-a-paris-portraits/download/?format=json&timezone=Europe/Berlin"
    }




}

