# Vonage Client Library

A library to support using the Vonage APIs on Android. Features:

* Force a cellular network request for use with [Vonage Number Verification](https://developer.vonage.com/en/number-verification/overview) and [Vonage Verify Silent Authentication](https://developer.vonage.com/en/verify/guides/silent-authentication)

## Installation

build.gradle -> dependencies add

```
implementation 'com.vonage:client-library:1.0.0'
```

## Usage

### Force a Cellular Network Request

```kotlin
import com.vonage.clientlibrary.VGCellularRequestClient
import com.vonage.clientlibrary.VGCellularRequestParameters

VGCellularRequestClient.initializeSdk(this.applicationContext)

val params = VGCellularRequestClientParameters(
    url = "http://www.vonage.com",
    headers = mapOf("x-my-header" to "My Value") ,
    queryParameters = mapOf("query-param" to "value"),
    maxRedirectCount = 10
)

val response = VGCellularRequestClient.getInstance().startCellularGetRequest(params, false)
if (response.optString("error") != "") {
    // error
} else {
    val status = response.optInt("http_status")
    val jsonReponse = response.getJSONObject("response_body") // Body of response parsed to JSON (NULL if not JSON)
    val rawReponse = response.optString("response_raw_body") // RAW string of response body (Only populated if not JSON)
    if (status == 200) {
        // 200 OK
    } else {
        // error
    }
}
```