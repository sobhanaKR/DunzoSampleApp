package com.example.dunzoproject

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dunzoproject.util.view.PhotosFragment


class MainActivity : AppCompatActivity() {

    var fragmentContainer: FrameLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.container)
        val photosFragment = PhotosFragment()
        val manager: FragmentManager = getSupportFragmentManager()
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.container, photosFragment, null)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }


}