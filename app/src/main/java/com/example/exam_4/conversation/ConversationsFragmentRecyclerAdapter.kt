package com.example.exam_4.conversation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_4.databinding.ItemConversationBinding

class ConversationsFragmentRecyclerAdapter: ListAdapter<ConversationItem,ConversationsFragmentRecyclerAdapter.ConversationItemViewHolder>(ConversationItemDiffUtil()) {

    inner class ConversationItemViewHolder(private val binding: ItemConversationBinding): RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: ConversationItem
        fun bind() {
            item = currentList[adapterPosition]
            with(binding){
                tvTitle.text = item.owner
                tvContent.text = item.lastMessage
                tvTime.text = item.lastActive

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
        override fun areItemsTheSame(oldItem: ConversationItem, newItem: ConversationItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ConversationItem, newItem: ConversationItem): Boolean {
            return oldItem == newItem
        }
    }
}