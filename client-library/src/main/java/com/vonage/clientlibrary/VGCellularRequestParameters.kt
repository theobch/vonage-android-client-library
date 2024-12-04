package com.vonage.clientlibrary

class VGCellularRequestParameters (
    val url: String,
    val headers: Map<String, String>,
    val queryParameters: Map<String, String>,
    val maxRedirectCount: Int = 10
)