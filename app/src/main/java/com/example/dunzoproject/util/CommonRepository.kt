package com.example.dunzoproject.util

fun createClient(): NetworkInterfaceKtx = API.retrofit.create(NetworkInterfaceKtx::class.java)