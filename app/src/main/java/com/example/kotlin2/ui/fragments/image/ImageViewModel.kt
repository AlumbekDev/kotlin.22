package com.example.kotlin2.ui.fragments.image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {

    val list: MutableLiveData<List<String>> = MutableLiveData()

}