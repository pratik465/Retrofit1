package com.pachchham.retrofit1

import com.pachchham.retrofit1.Modal.CatModal
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("cat?json=true")
    fun getCat(): Call<CatModal>
}