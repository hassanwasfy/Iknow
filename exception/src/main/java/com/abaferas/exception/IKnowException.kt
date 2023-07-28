package com.abaferas.exception

sealed class IKnowException(val errorMessage: String): Exception() {
    data object TooManyRequests: IKnowException("Too Many Requests")
    data object NotAuthorized: IKnowException("Not Authorized User")
    data object NoInternetConnection: IKnowException("No Internet Connection")
    data object ServiceUnAvailable: IKnowException("Service UnAvailable")
    data object NullResponseBody: IKnowException("Null Response Body")
}