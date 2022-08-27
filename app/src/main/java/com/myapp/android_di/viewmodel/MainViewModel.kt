package com.myapp.android_di.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapp.android_di.model.Post
import com.myapp.android_di.network.service.PostService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Eldor Turgunov on 27.08.2022.
 * Android mvvm
 * eldorturgunov777@gmail.com
 */
@HiltViewModel
class MainViewModel @Inject constructor(val postService : PostService) : ViewModel() {
    val allPosts = MutableLiveData<ArrayList<Post>>()

    fun apiPostList() {
        postService.listPost().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                allPosts.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                allPosts.value = ArrayList()
            }
        })
    }
}