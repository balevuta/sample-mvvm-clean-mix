package com.ethan.bridj.utils

import com.ethan.bridj.utils.DateFormat.DATE_LONG_FORMAT
import com.ethan.bridj.utils.DateFormat.STANDARD_DATETIME_FORMAT
import java.time.LocalDate
import java.time.LocalDate.now
import java.time.ZoneId
import java.util.*

fun Int?.orDefault(def: Int): Int = this ?: def

fun Double?.orDefault(def: Double): Double = this ?: def

fun String.toStandardDateDisplay(): String {
    try {
        var localDate = now()
        if (this.isNotEmpty()) {
            try {
                DATE_LONG_FORMAT.parse(this)?.let {
                    localDate = it.convertToLocalDateViaInstant()
                }
                return localDate.format(STANDARD_DATETIME_FORMAT)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return ""
}

fun Date.convertToLocalDateViaInstant(): LocalDate {
    return this.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
}