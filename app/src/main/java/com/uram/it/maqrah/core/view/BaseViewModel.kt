package com.uram.it.maqrah.core.view

import androidx.lifecycle.ViewModel
import com.uram.it.maqrah.core.utils.SingleLiveEvent

open class BaseViewModel : ViewModel() {

  var dataLoadingEvent: SingleLiveEvent<Int> = SingleLiveEvent()

}