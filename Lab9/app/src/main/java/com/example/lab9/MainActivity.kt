package com.example.lab9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: PostsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        showPosts()
        createPost()
    }
    private val baseURL = "https://jsonplaceholder.typicode.com/"
    var postList = ArrayList<Posts>()

    fun showPosts(){
        var retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitAPI:RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call: Call<List<Posts>> = retrofitAPI.getAllPosts()
        call.enqueue(object:Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if(response.isSuccessful){
                    binding.progressBar.isVisible = false
                    binding.recyclerView.isVisible = true
                    postList = response.body() as ArrayList<Posts>
                    adapter = PostsAdapter(postList, applicationContext)
                    binding.recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun createPost(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitAPI:RetrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val newPost = Posts(1, 1, "Post", "Look, this is new post!")
        val call:Call<Posts> = retrofitAPI.createNewPost(newPost)
        call.enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful) {
                    val createdPost = response.body()
                    Toast.makeText(applicationContext, "Post created", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Failed to create post", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}