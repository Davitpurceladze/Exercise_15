package com.example.exam_4.conversation

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object Network {

    private const val BASE_URL = "https://run.mocky.io"
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    val retrofit: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }
    interface ApiService {
        @GET("/v3/744fa574-a483-43f6-a1d7-c65c87b5d9b2")
        suspend fun getConversationData(): Response<List<ConversationItem>>
    }
}