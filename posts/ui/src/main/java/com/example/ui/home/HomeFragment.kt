package com.example.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.databinding.FragmentHomeBinding
import androidx.fragment.app.activityViewModels
import com.example.domain.utils.ResponseState
import com.example.ui.home.adapter.PostAdapter
import com.example.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by activityViewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coroutineScope = CoroutineScope(Dispatchers.IO)
        val adapter = PostAdapter(null)
        coroutineScope.launch {
            val posts = viewModel.getPosts()
            posts.collect {
                when (it) {
                    is ResponseState.Success -> {
                        it.data.forEach { post ->
                            adapter.changeList(listOf(post))
                        }
                    }

                    is ResponseState.Failed -> {
                        it.e
                        Log.e("HomeFragment", "onViewCreated: ${it.e}")
                    }

                    is ResponseState.Loading -> {
                        Log.e("HomeFragment", "onViewCreated: Loading")
                    }

                    else -> {

                    }
                }
            }
        }
        binding.homeFragmentRecycler.adapter = adapter
    }
}