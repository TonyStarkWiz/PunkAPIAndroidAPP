package com.android.punkapiandroidapp.rest

import com.android.punkapiandroidapp.model.BeersDetailsItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeersAPI {

    @GET("beers")
     fun getData(): Call<List<BeersDetailsItem>>
}