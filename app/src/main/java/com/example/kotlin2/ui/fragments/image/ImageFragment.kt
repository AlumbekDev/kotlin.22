package com.example.kotlin2.ui.fragments.image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2.R
import com.example.kotlin2.databinding.FragmentImageBinding
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class ImageFragment : Fragment(R.layout.fragment_image) {

    private val binding by viewBinding(FragmentImageBinding::bind)

    private var list: ArrayList<String> = ArrayList()

    private val viewModel: ImageViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupClickOk()
    }

    private fun setupClickOk() {
        binding.submitBtn.setOnClickListener {
            list.add(binding.edittext.text.toString())
            binding.edittext.setText("")
            viewModel.list.value = list
        }

        binding.btnRandom.setOnClickListener {
            val random = Random().nextInt(list.size)
            Picasso.get().load(list[random]).into(binding.imageview)
        }
    }

    private fun initialize() {
        list.apply {
            add("https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGhvdG98ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
            add("https://images.pexels.com/photos/3680219/pexels-photo-3680219.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
            add("https://images.unsplash.com/photo-1554080353-a576cf803bda?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cGhvdG98ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
            add("https://thumbs.dreamstime.com/b/racial-love-white-caucasion-black-african-american-hands-shaped-as-interracial-heart-representing-world-unity-ethnic-162292478.jpg")
            add("https://picjumbo.com/wp-content/uploads/woman-holding-an-american-flag-in-a-field-free-photo-1080x1620.jpg")
        }
        viewModel.list.value = list
    }

}