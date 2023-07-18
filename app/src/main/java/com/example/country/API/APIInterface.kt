package com.example.country.API

import com.example.country.Countrymodel
import retrofit2.Call
import retrofit2.http.GET


interface APIInterface {
    @GET("all")
    fun getCountries(): Call<List<Countrymodel>>
}