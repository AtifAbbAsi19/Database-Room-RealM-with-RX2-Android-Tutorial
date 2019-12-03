package com.droid.databasetutorial.utils

object ValidatorUtils {

    fun hasValue(value: String): Boolean {
        return value.isNotEmpty() && value != "null" && value != "NULL"
    }

}