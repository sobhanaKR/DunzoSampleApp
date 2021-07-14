package com.example.dunzoproject.util

import com.example.dunzoproject.util.model.PhotosMainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface  NetworkInterfaceKtx {

    @GET("/services/rest?")
    suspend fun getPhotosData(
        @Query("method") method: String?,
        @Query("api_key") apiKey:String ?,
        @Query("format") format:String ?,
        @Query("text") text:String ?,
        @Query("nojsoncallback") noJsonCallBack:Int ?,
        @Query("per_page") perPage:Int ?,
        @Query("page") page:Int ?
    ): PhotosMainModel?
}