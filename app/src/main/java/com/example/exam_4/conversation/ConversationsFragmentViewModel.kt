package com.example.exam_4.conversation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow

class ConversationsFragmentViewModel: ViewModel() {
    private val _conversationFlow = MutableStateFlow<List<ConversationItem>>(emptyList())
    val conversationFlow: SharedFlow<List<ConversationItem>> get() = _conversationFlow.asStateFlow()

    val data = """
        [
           {
              "id":1,
              "image":"https://www.alia.ge/wp-content/uploads/2022/09/grisha.jpg",
              "owner":"გრიშა ონიანი",
              "last_message":"თავის ტერიტორიას ბომბავდა",
              "last_active":"4:20 PM",
              "unread_messages":3,
              "is_typing":false,
              "laste_message_type":"text"
           },
           {
              "id":2,
              "image":null,
              "owner":"ჯემალ კაკაურიძე",
              "last_message":"შემოგევლე",
              "last_active":"3:00 AM",
              "unread_messages":0,
              "is_typing":true,
              "laste_message_type":"voice"
           },
           {
              "id":3,
              "image":"https://i.ytimg.com/vi/KYY0TBqTfQg/hqdefault.jpg",
              "owner":"გურამ ჯინორია",
              "last_message":"ცოცხალი ვარ მა რა ვარ შე.. როდის იყო კვტარი ტელეფონზე ლაპარაკობდა",
              "last_active":"1:00 ",
              "unread_messages":0,
              "is_typing":false,
              "laste_message_type":"file"
           },
           {
              "id":4,
              "image":"",
              "owner":"კაკო წენგუაშვილი",
              "last_message":"ადამიანი რო მოსაკლავად გაგიმეტებს თანაც ქალი ის დასანდობი არ არი",
              "last_active":"1:00 PM",
              "unread_messages":0,
              "is_typing":false,
              "laste_message_type":"text"
           }
        ]

    """.trimIndent()

     val moshi: Moshi = Moshi.Builder().Build

}


