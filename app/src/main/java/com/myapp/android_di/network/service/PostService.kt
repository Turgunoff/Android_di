package com.myapp.android_di.network.service

import com.myapp.android_di.model.Post
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Created by Eldor Turgunov on 27.08.2022.
 * Android mvvm
 * eldorturgunov777@gmail.com
 */
interface PostService {

 @Headers(
  "Content-type:application/json"
 )

 @GET("posts")
 fun listPost(): Call<ArrayList<Post>>

 @DELETE("posts/{id}")
 fun deletePost(@Path("id") id: Int): Call<Post>

}