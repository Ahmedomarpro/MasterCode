package com.uram.it.maqrah.core.view.extensions

import androidx.fragment.app.Fragment
import com.uram.it.maqrah.R
import com.uram.it.maqrah.core.network.FailureStatus
import com.uram.it.maqrah.core.network.Resource
import com.uram.it.maqrah.core.utils.hideSoftInput
import com.uram.it.maqrah.core.utils.showNoInternetAlert

fun Fragment.handleApiError(
  failure: Resource.Failure,
  retryAction: (() -> Unit)? = null,
  noDataAction: (() -> Unit)? = null,
  noInternetAction: (() -> Unit)? = null
) {
  when (failure.failureStatus) {
    FailureStatus.API_FAIL, FailureStatus.SERVER_SIDE_EXCEPTION -> {
      noDataAction?.let {
        it()
      }

      requireView().showSnackBar(
        resources.getString(R.string.some_error),
        resources.getString(R.string.retry),
        retryAction
      )
    }
    FailureStatus.TOKEN_EXPIRED -> {
      // TODO : CALL API TO REFRESH TOKEN
      // OR (depends on your application business)
      // TODO : LOG OUT
    }
    FailureStatus.NO_INTERNET -> {
      noInternetAction?.let {
        it()
      }

      showNoInternetAlert(requireActivity())
    }
    FailureStatus.OTHER -> {
      noDataAction?.let {
        it()
      }

      requireView().showSnackBar(
        resources.getString(R.string.some_error),
        resources.getString(R.string.retry),
        retryAction
      )
    }
  }
}

/*
fun Fragment.showMessage(message: String?) = showMessage(requireContext(), message)
*/

fun Fragment.hideKeyboard() = hideSoftInput(requireActivity())

fun Fragment.showNoInternetAlert() = showNoInternetAlert(requireActivity())


fun Fragment.showError(message: String, retryActionName: String? = null, action: (() -> Unit)? = null) =
  requireView().showSnackBar(message, retryActionName, action)
