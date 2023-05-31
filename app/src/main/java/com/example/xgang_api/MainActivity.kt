package com.example.xgang_api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xgang_api.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var apiViewModel: ApiViewModel
    lateinit var responseAdapter: ResponseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        responseAdapter = ResponseAdapter(emptyList())
        binding.recyclerView.adapter = responseAdapter

        apiViewModel = ViewModelProvider(this)[ApiViewModel::class.java]
        apiViewModel.getUserList().observe(this, Observer { users ->
            responseAdapter = ResponseAdapter(users)
            binding.recyclerView.adapter = responseAdapter
        })

        apiViewModel.fetchUserList(this)
    }
}