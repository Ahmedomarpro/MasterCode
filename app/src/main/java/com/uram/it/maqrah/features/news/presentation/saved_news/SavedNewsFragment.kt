package com.uram.it.maqrah.features.news.presentation.saved_news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uram.it.maqrah.R

class SavedNewsFragment : Fragment() {

    companion object {
        fun newInstance() = SavedNewsFragment()
    }

    private lateinit var viewModel: SavedNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.saved_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SavedNewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}