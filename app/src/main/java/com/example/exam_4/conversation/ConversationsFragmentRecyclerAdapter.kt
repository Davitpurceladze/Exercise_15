package com.example.exam_4.conversation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exam_4.R
import com.example.exam_4.databinding.ItemConversationBinding

class ConversationsFragmentRecyclerAdapter :
    ListAdapter<ConversationItem, ConversationsFragmentRecyclerAdapter.ConversationItemViewHolder>(
        ConversationItemDiffUtil()
    ) {

    inner class ConversationItemViewHolder(private val binding: ItemConversationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: ConversationItem
        fun bind() {
            item = currentList[adapterPosition]
            with(binding) {
                tvTitle.text = item.owner
                tvTime.text = item.lastActive
            }
            setImage()
            setLastMessageType()
            setUnreadMessages()

        }

        private fun setImage() {
            Glide.with(this.itemView)
                .load(item.image)
                .placeholder(R.drawable.ic_girl)
                .into(binding.imgProfile)
        }
        private fun setLastMessageType() {
            if (item.lastMessageType == ConversationItem.LastMessageType.VOICE) {
                with(binding) {
                    tvContent.visibility = ViewGroup.GONE
                    imgVoice.visibility = ViewGroup.VISIBLE
                    tvLastMessageVoice.visibility = ViewGroup.VISIBLE
                }
            } else if (item.lastMessageType == ConversationItem.LastMessageType.FILE) {
                with(binding) {
                    tvContent.visibility = ViewGroup.GONE
                    imgFile.visibility = ViewGroup.VISIBLE
                    tvLastMessageFile.visibility = ViewGroup.VISIBLE
                }
            } else {
                binding.tvContent.text = item.lastMessage
            }
        }
        private fun setUnreadMessages() {
            if(item.unreadMessages != 0) {
                with(binding) {
                    tvUnreadMessages.visibility = ViewGroup.VISIBLE
                    tvUnreadMessages.text = item.unreadMessages.toString()

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemConversationBinding.inflate(layoutInflater, parent, false)
        return ConversationItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConversationItemViewHolder, position: Int) {
        holder.bind()
    }

    class ConversationItemDiffUtil : DiffUtil.ItemCallback<ConversationItem>() {
        override fun areItemsTheSame(
            oldItem: ConversationItem,
            newItem: ConversationItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ConversationItem,
            newItem: ConversationItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}