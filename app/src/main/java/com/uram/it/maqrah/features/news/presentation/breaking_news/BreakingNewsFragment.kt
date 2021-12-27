package com.uram.it.maqrah.features.news.presentation.breaking_news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uram.it.maqrah.R

class BreakingNewsFragment : Fragment() {

    companion object {
        fun newInstance() = BreakingNewsFragment()
    }

    private lateinit var viewModel: BreakingNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.breaking_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BreakingNewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}