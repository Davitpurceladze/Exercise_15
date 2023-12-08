package com.example.exam_4.conversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalStdlibApi::class)
class ConversationsFragmentViewModel: ViewModel() {
    private val _conversationFlow = MutableStateFlow<List<ConversationItem>>(emptyList())
    val conversationFlow: SharedFlow<List<ConversationItem>> get() = _conversationFlow.asStateFlow()


    init {
        viewModelScope.launch {
            val data = Network.retrofit.getConversationData()
            _conversationFlow.value = _conversationFlow.value.toMutableList().also {
                it.addAll(
                    data.body()!!
                )
            }
        }
    }

}


