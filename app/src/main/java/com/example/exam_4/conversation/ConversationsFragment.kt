package com.example.exam_4.conversation

import com.example.exam_4.BaseFragment
import com.example.exam_4.databinding.FragmentConversationsBinding


class ConversationsFragment : BaseFragment<FragmentConversationsBinding>(FragmentConversationsBinding::inflate) {

    override fun setUp() {
        println("fragment works")
    }
}