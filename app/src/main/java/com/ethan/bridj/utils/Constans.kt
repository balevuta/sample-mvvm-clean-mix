package com.ethan.bridj.utils

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

const val BASE_URL = "https://s3-ap-southeast-2.amazonaws.com/"

object DateFormat {
    val DATE_LONG_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
    val STANDARD_DATETIME_FORMAT: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy MMM dd", Locale.ENGLISH)
}