package com.example.exam_4.conversation

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConversationItem(
    val id: Int,
    val image: String?,
    val owner: String,
    @Json(name ="last_message") val lastMessage: String,
    @Json(name ="last_active") val lastActive: String,
    @Json(name ="unread_messages") val unreadMessages: Int,
    @Json(name ="is_typing") val isTyping: Boolean,
    @Json(name ="laste_message_type") val lastMessageType: LastMessageType

) {

    enum class LastMessageType {

        @Json(name = "text")TEXT,
        @Json(name = "file")FILE,
        @Json(name = "voice")VOICE
    }

}



