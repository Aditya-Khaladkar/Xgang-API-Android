package com.example.xgang_api

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.google.gson.Gson

class ApiViewModel : ViewModel() {
    private val userList = MutableLiveData<List<ResponseData>>()

    fun getUserList(): LiveData<List<ResponseData>> {
        return userList
    }

    fun fetchUserList(context: Context) {
        val url = "https://xgang-api.azurewebsites.net/xgang/"

        val request = JsonArrayRequest(Request.Method.GET, url, null,
            { response ->
                val gson = Gson()
                val users = gson.fromJson(response.toString(), Array<ResponseData>::class.java).toList()
                userList.value = users
            },
            { error ->
                Log.e("UserViewModel", "Error fetching user list: ${error.message}")
            }
        )

        // Add the request to the Volley request queue
        // Assuming you have a VolleyRequestQueue singleton class
        VolleyRequestQueue.getInstance(context).addToRequestQueue(request)
    }
}