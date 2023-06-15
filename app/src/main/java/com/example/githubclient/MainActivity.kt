package com.example.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.githubclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private var binding: ActivityMainBinding? = null

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btn1?.setOnClickListener { presenter.counterClick(INDEX_BUTTON_1) }
        binding?.btn2?.setOnClickListener { presenter.counterClick(INDEX_BUTTON_2) }
        binding?.btn3?.setOnClickListener { presenter.counterClick(INDEX_BUTTON_3) }
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            INDEX_BUTTON_1 -> binding?.btn1?.text = text
            INDEX_BUTTON_2 -> binding?.btn2?.text = text
            INDEX_BUTTON_3 -> binding?.btn3?.text = text
        }
    }
}