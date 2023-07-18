package com.example.country.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIclient {

    companion object {
        val BASE_URL = "https://restcountries.com/v2/"
        var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}