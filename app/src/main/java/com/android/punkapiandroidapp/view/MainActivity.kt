package com.android.punkapiandroidapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.android.punkapiandroidapp.R
import com.android.punkapiandroidapp.model.BeersDetailsItem
import com.android.punkapiandroidapp.rest.BeersAPI
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import com.android.punkapiandroidapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*


const val BASE_URL = "https://api.punkapi.com/v2/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(BeersAPI:: class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<BeersDetailsItem>?> {
            override fun onResponse(
                call: Call<List<BeersDetailsItem>?>,
                response: Response<List<BeersDetailsItem>?>
            ) { val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }

                txtId.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<BeersDetailsItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: "+t.message)
            }
        })
    }

}



















































































