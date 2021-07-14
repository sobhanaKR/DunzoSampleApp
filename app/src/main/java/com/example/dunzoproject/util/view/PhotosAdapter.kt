package com.example.dunzoproject.util.view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dunzoproject.R
import com.example.dunzoproject.databinding.PhotoDesignLayoutBinding
import com.example.dunzoproject.util.viewmodel.PhotosViewModel


class PhotosAdapter(private var viewModel: PhotosViewModel)
    : RecyclerView.Adapter<PhotosAdapter.PhotosVH>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosVH {
        val mBinding:PhotoDesignLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.photo_design_layout, parent, false
        )
        return PhotosVH(mBinding, viewModel)
    }


    override fun onBindViewHolder(holder: PhotosVH, position: Int) {
        holder.bind(holder,position)

    }

    override fun getItemCount(): Int {
        return viewModel.getPhotosCount()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class PhotosVH(
        private var mBinding: PhotoDesignLayoutBinding,
        private var viewModel: PhotosViewModel
    )
        : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(holder: PhotosVH, position: Int) {

            mBinding.viewModel = viewModel
            mBinding.position = position
        }

    }



}
