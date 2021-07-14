package com.example.dunzoproject.util

object Repository {

    suspend fun fetchPhotos(searchText:String) = createClient().getPhotosData("flickr.photos.search", "062a6c0c49e4de1d78497d13a7dbb360",
    "json", searchText, 1, 2, 1)
}