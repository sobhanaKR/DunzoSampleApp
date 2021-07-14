package com.example.dunzoproject.util.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.dunzoproject.R
import com.example.dunzoproject.databinding.PhotosMainLayoutBinding
import com.example.dunzoproject.util.viewmodel.PhotosViewModel
import com.example.dunzoproject.util.viewmodel.PhotosViewModel.Companion.NONE
import com.example.dunzoproject.util.viewmodel.PhotosViewModel.Companion.ON_FILTER_REFRESH_ADAPTER


class PhotosFragment : Fragment() {
    lateinit var binding:PhotosMainLayoutBinding
    var adapter:PhotosAdapter ?= null
    private val viewModel: PhotosViewModel? by lazy {
        activity?.let {
            ViewModelProviders.of(it)
                .get(PhotosViewModel::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("check", "create fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(activity),
            R.layout.photos_main_layout, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.fetchPhotosCall()
        Log.i("check", "viewcreated fragment")
        viewModel?.photosDataResponse?.observe(viewLifecycleOwner) { data ->
            Log.i("check", "success")
            adapter = viewModel?.let { it1 -> PhotosAdapter(it1) }
            binding.viewModel = viewModel
             binding.adapter = adapter
        }
        val textWatcher = object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                viewModel?.searchText = s.toString()
               viewModel?.fetchPhotosCall()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        }

        binding.searchText.addTextChangedListener(textWatcher)
        viewModel?.uiEvent?.observe(viewLifecycleOwner){
                event ->
            handleUiEvent(event)
        }
    }



    private fun handleUiEvent(event: Int?) {
        when (event) {
           NONE -> {
            }
            ON_FILTER_REFRESH_ADAPTER -> {
                (binding as PhotosMainLayoutBinding).adapter?.notifyDataSetChanged()
            }
        }
    }

}



