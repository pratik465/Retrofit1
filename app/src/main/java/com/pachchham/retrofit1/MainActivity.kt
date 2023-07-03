package com.pachchham.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.pachchham.retrofit1.Modal.ApiClient
import com.pachchham.retrofit1.Modal.CatModal
import com.pachchham.retrofit1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChangeImage.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        var api  =ApiClient.getApiClient().create(ApiInterface::class.java)
        api.getCat().enqueue(object : Callback<CatModal>{
            override fun onResponse(call: Call<CatModal>, response: Response<CatModal>) {
                if (response.isSuccessful) {
                    var data = response.body()
                    Glide.with(this@MainActivity).load(ApiClient.Base_URL+data?.url).into(binding.imgImage)
                }
            }

            override fun onFailure(call: Call<CatModal>, t: Throwable) {
            }
        })

    }
}