package com.uram.it.maqrah.features.splash.presentation

import android.os.Handler
import android.os.Looper
import com.uram.it.maqrah.core.view.BaseActivity
import com.uram.it.maqrah.R
import com.uram.it.maqrah.core.view.extensions.openActivityAndClearStack
import com.uram.it.maqrah.databinding.ActivitySplashBinding
import com.uram.it.maqrah.features.news.NewsActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

  override
  fun getLayoutId() = R.layout.activity_splash

  override
  fun setUpViews() {
    decideNavigationLogic()
  }

  private fun decideNavigationLogic() {
    Handler(Looper.getMainLooper()).postDelayed({
      openActivityAndClearStack(NewsActivity::class.java)
    }, 2000)
  }
}