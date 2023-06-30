package com.example.githubclient.presenter.list

import com.example.githubclient.view.list.IItemView

interface IListPresenter<V : IItemView> {

    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}