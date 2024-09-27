package com.example.foundation.interaction.util

import java.util.Locale

const val EMPTY_STRING = ""

fun String.Companion.emptyValue() = EMPTY_STRING

fun Int.Companion.emptyValue() = 0

fun Float.Companion.emptyValue() = 0f

fun Double.Companion.emptyValue() = 0.0

fun Boolean.Companion.emptyValue() = false

fun Long.Companion.emptyValue() = 0L

fun String?.getValueOrEmpty() = this ?: EMPTY_STRING

fun Int?.getValueOrEmpty() = this ?: 0

fun Boolean?.getValueOrFalse() = this ?: false

fun String?.getFormattedValueOrDefault() = this ?: EMPTY_STRING

fun String?.toUppercase() = this?.uppercase(Locale.getDefault()) ?: EMPTY_STRING

fun Long?.getValueOrZero() = this ?: 0L