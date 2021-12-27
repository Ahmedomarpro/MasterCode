package com.uram.it.maqrah.core.data_source


import com.uram.it.maqrah.core.network.FailureStatus
import com.uram.it.maqrah.core.network.Resource
import com.uram.it.maqrah.core.network.ResponseStatus
import com.uram.it.maqrah.features.news.domain.entity.response.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

open class BaseRemoteDataSource @Inject constructor() {

  companion object {
    const val LIST_PAGE_SIZE = 10
  }

  suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    return withContext(Dispatchers.IO) {
      try {
        val apiResponse: T = apiCall.invoke()

        if ((apiResponse as NewsResponse).status == ResponseStatus.SUCCESS) {
          if ((apiResponse as NewsResponse).totalResults == 0) {
            Resource.Empty
          } else {
            Resource.Success(apiResponse)
          }
        } else {
          Resource.Failure(FailureStatus.API_FAIL, 200, "Error from api")
        }
      } catch (throwable: Throwable) {
        when (throwable) {
          is HttpException -> {
            if (throwable.code() == 401) {
              Resource.Failure(FailureStatus.TOKEN_EXPIRED, throwable.code(), throwable.response()?.errorBody().toString())
            } else {
              Resource.Failure(FailureStatus.SERVER_SIDE_EXCEPTION, throwable.code(), throwable.response()?.errorBody().toString())
            }
          }

          is UnknownHostException -> {
            Resource.Failure(FailureStatus.NO_INTERNET, null, null)
          }

          else -> {
            Resource.Failure(FailureStatus.OTHER, null, null)
          }
        }
      }
    }
  }
}