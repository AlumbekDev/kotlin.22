package com.example.kotlin2.ui.fragments.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2.R
import com.example.kotlin2.databinding.FragmentGalleryBinding
import com.example.kotlin2.databinding.FragmentImageBinding
import com.example.kotlin2.ui.adapters.PhotoAdapter
import com.example.kotlin2.ui.fragments.image.ImageViewModel

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val binding by viewBinding(FragmentGalleryBinding::bind)
    private val viewModel: ImageViewModel by activityViewModels()

    private val photoAdapter: PhotoAdapter = PhotoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequest()
    }

    private fun setupRequest() {
        viewModel.list.observe(viewLifecycleOwner, {
            photoAdapter.addList(it)
        })
    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = photoAdapter
        }

    }
}