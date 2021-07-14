package com.example.dunzoproject.util.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotosModel(
    @SerializedName("page")
    var page: String?,
    @SerializedName("pages")
    var pages: String?,
    @SerializedName("perpage")
    var perPage : String?,
    @SerializedName("total")
    var total : String?,
    @SerializedName("photo")
    var photoArray :  ArrayList<PhotoArrayModel>?

): Parcelable