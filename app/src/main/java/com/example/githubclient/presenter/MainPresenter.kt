package com.example.githubclient.presenter

import com.example.githubclient.model.GithubUser
import com.example.githubclient.model.GithubUsersRepo
import com.example.githubclient.navigation.IScreens
import com.example.githubclient.presenter.list.IUsersListPresenter
import com.example.githubclient.view.MainView
import com.example.githubclient.view.list.IUserIItemView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClick() {
        router.exit()
    }
}