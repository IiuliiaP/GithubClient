package com.example.githubclient.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemUserBinding
import com.example.githubclient.presenter.list.IUsersListPresenter
import com.example.githubclient.view.list.IUserIItemView

const val INVALID_INDEX = -1

class UsersRecyclerViewAdapter(private val presenter: IUsersListPresenter) : RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root), IUserIItemView {

        override fun setLogin(text: String) {
            binding.userLogin.text = text
        }

        override var pos = INVALID_INDEX
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply {
        pos = position
    })
}