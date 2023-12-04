package com.example.exam_4.conversation

data class ConversationItem(
    val id: Int,
    val image: String,
    val owner: String,
    val lastMessage: String,
    val lastActive: String,
    val unreadMessages: Int,
    val isTyping: Boolean,
    val lastMessageType:LastMessageType,


)

enum class LastMessageType {
    TEXT, VOICE, FILE
}


//{
//    "id":1,
//    "image":"https://www.alia.ge/wp-content/uploads/2022/09/grisha.jpg",
//    "owner":"გრიშა ონიანი",
//    "last_message":"თავის ტერიტორიას ბომბავდა",
//    "last_active":"4:20 PM",
//    "unread_messages":3,
//    "is_typing":false,
//    "laste_message_type":"text"
//}
