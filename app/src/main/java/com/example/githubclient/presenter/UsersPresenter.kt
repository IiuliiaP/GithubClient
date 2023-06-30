package com.example.githubclient.presenter

import com.example.githubclient.model.GithubUser
import com.example.githubclient.model.GithubUsersRepo
import com.example.githubclient.navigation.AndroidScreens
import com.example.githubclient.presenter.list.IUsersListPresenter
import com.example.githubclient.view.UsersView
import com.example.githubclient.view.list.IUserIItemView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router): MvpPresenter<UsersView>() {

    class UsersListPresenter : IUsersListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((IUserIItemView) -> Unit)? = null


        override fun bindView(view: IUserIItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()

        usersListPresenter.itemClickListener = {
            iUserIItemView ->  router.navigateTo(AndroidScreens().login())
        }
    }

    private fun loadData(){
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}