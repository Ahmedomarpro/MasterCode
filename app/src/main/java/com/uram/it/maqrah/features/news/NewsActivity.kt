package com.uram.it.maqrah.features.news


import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
 import com.uram.it.maqrah.core.view.BaseActivity
import com.uram.it.maqrah.R
import com.uram.it.maqrah.core.view.extensions.setupWithNavController
import com.uram.it.maqrah.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : BaseActivity<ActivityNewsBinding>() {

  override
  fun getLayoutId() = R.layout.activity_news

  @RequiresApi(Build.VERSION_CODES.S)
  override
  fun setUpBottomNavigation() {
    val graphIds = listOf(
      R.navigation.nav_breaking_news,
      R.navigation.nav_saved_news,
      R.navigation.nav_search_news
    )

/*
    val controller = binding.bottomNavigationView.setupWithNavController(
      graphIds,
      supportFragmentManager,
      R.id.fragment_host_container,
      intent
    )

    navController = controller
*/

    val controller =  binding.button.setOnClickListener {  }

   }



}