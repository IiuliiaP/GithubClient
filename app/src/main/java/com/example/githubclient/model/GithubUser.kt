package com.example.githubclient.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class GithubUser(val login: String) : Parcelable