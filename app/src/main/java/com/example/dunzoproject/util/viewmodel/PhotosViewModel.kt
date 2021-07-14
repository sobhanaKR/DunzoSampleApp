package com.example.dunzoproject.util.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dunzoproject.util.Repository
import com.example.dunzoproject.util.model.PhotoArrayModel
import com.example.dunzoproject.util.model.PhotosMainModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.util.*

class PhotosViewModel(application: Application) : AndroidViewModel(application) {

    val networkContext by lazy { Dispatchers.IO + getExceptionHandler(getApplication(), false) }
    val failure = MutableLiveData<Response<*>>()
    var searchText:String = "abc"
    var searchableText : ArrayList<PhotoArrayModel> = ArrayList()
    var photosDataResponse = MutableLiveData<PhotosMainModel>()

    val uiEvent = MutableLiveData<Int>(NONE)

    companion object{
        const val NONE = 0
        const val ON_FILTER_REFRESH_ADAPTER = 5
    }

    private fun getExceptionHandler(
        context: Context,
        showApiFailureMessage: Boolean,
        failureResponse: MutableLiveData<Response<*>> = failure
    ): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, exception ->
            Log.d("check", "Coroutine Exception: ${exception.localizedMessage}")
            exception.printStackTrace()


            var msg = "Coroutine Exception: ${exception.localizedMessage}"
            if (exception is HttpException) {
                Log.d("check", "Coming here ")

            }
        }
    }



    fun fetchPhotosCall() =
        viewModelScope.launch(networkContext) {
            photosDataResponse.postValue(Repository.fetchPhotos(searchText))
        }


    fun getPhotosCount(): Int {
        return photosDataResponse.value?.photosModel?.photoArray?.size!!
    }

    fun getUrl(position: Int): String {
        return "https://farm"+photosDataResponse.value?.photosModel?.photoArray?.get(position)?.farm +
                ".staticflickr.com/"+photosDataResponse.value?.photosModel?.photoArray?.get(position)?.server+"/"+
                photosDataResponse.value?.photosModel?.photoArray?.get(position)?.id+"_"+
                photosDataResponse.value?.photosModel?.photoArray?.get(position)?.secret+"_m.jpg"
    }
    fun getTitle(position: Int): String? {
        return photosDataResponse.value?.photosModel?.photoArray?.get(position)?.Title
    }
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                try {
//                    searchableText.clear()
//                    searchableText =  results?.values as ArrayList<*>
//                    uiEvent.value = ON_FILTER_REFRESH_ADAPTER
//                } catch (e: java.lang.Exception) {
//                    Log.i("check","exception")
//                }
//            }
//
//
//
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val filterResults = FilterResults()
//                val queryString = searchText
//                filterResults.values = if (queryString.isEmpty()) {
//                    //countryVisibility.value = false
//                }
//                else
//                    searchableText.filter {
//                        it.Title?.contains(queryString,ignoreCase = true) == true
//                    }
//                return filterResults
//            }
//
//        }
//    }

}