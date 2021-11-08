package com.elhady.emitter.data.remote

import com.elhady.emitter.data.model.User
import retrofit2.http.GET

/**
 * Created by islam elhady on 08-Nov-21.
 */
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}