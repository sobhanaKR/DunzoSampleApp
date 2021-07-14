package com.example.dunzoproject.util.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoArrayModel(
    @SerializedName("id")
    var id: String?,
    @SerializedName("owner")
    var owner: String?,
    @SerializedName("secret")
    var secret : String?,
    @SerializedName("server")
    var server : String?,
    @SerializedName("farm")
    var farm : String?,
    @SerializedName("title")
    var Title : String?,
    @SerializedName("ispublic")
    var isPublic : Int?,
    @SerializedName("isfriend")
    var isFriend : Int?,
    @SerializedName("isfamily")
    var isFamily : Int?,

): Parcelable