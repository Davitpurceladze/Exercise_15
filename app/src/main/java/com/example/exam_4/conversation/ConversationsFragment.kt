package com.example.exam_4.conversation

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.exam_4.BaseFragment
import com.example.exam_4.databinding.FragmentConversationsBinding
import kotlinx.coroutines.launch


class ConversationsFragment :
    BaseFragment<FragmentConversationsBinding>(FragmentConversationsBinding::inflate) {

    private val viewModel: ConversationsFragmentViewModel by viewModels()
    private lateinit var ConversationsFragmentRecyclerAdapter: ConversationsFragmentRecyclerAdapter

    override fun setUp() {
        ConversationsFragmentRecyclerAdapter = ConversationsFragmentRecyclerAdapter()
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =ConversationsFragmentRecyclerAdapter
        }
    }

    override fun bindObserves() {
         viewLifecycleOwner.lifecycleScope.launch {
             repeatOnLifecycle(Lifecycle.State.STARTED) {
                 viewModel.conversationFlow.collect{
                     ConversationsFragmentRecyclerAdapter.submitList(it)
                 }
             }
         }
    }
}


