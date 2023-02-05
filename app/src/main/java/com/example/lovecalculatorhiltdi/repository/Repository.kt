package com.example.lovecalculatorhiltdi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculatorhiltdi.remote.RetrofitService
import com.example.lovecalculatorhiltdi.remote.LoveApi
import com.example.lovecalculatorhiltdi.remote.LoveModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

class Repository @Inject constructor(private val api: LoveApi) {
    fun getLove(firstName : String, secondName: String)
            : MutableLiveData<LoveModel>{
        val livelove = MutableLiveData<LoveModel>()
        api.calculateLove(firstName,secondName).enqueue(object : retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    livelove.postValue(response.body())
                }

            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")

            }

        })

        return livelove
    }
}