package com.example.githubclient.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.App
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentUsersBinding
import com.example.githubclient.model.GithubUsersRepo
import com.example.githubclient.presenter.UsersPresenter
import com.example.githubclient.ui.BackButtonListener
import com.example.githubclient.ui.adapter.UsersRecyclerViewAdapter
import com.example.githubclient.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    var adapter: UsersRecyclerViewAdapter? = null

    val presenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), App.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = UsersFragment()
    }

    override fun backPressed() = presenter.backPressed()

    override fun init() {
        binding.usersRecycleView.layoutManager = LinearLayoutManager(context)
        adapter = UsersRecyclerViewAdapter(presenter.usersListPresenter)
        binding.usersRecycleView.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}