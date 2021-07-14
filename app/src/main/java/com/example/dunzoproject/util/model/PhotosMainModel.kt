package com.example.dunzoproject.util.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotosMainModel(
    @SerializedName("photos")
    var photosModel: PhotosModel?

): Parcelable