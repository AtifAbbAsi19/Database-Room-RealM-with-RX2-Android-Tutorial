package com.droid.databasetutorial.data.utils

import androidx.room.TypeConverter
import com.droid.databasetutorial.data.entity.Address
import com.droid.databasetutorial.data.entity.ContactNumber

class TypeConvertersUtils {

    /**
     * @Link developer.android.com/reference/android/arch/persistence/room/TypeConverters
     */

    companion object {

        @JvmStatic
        @TypeConverter
        fun toAddress(email: String): Address? {
            return if (email == null) null else Address(-1, email)
        }

        @JvmStatic
        @TypeConverter
        fun toContactNumber(email: String): ContactNumber? {
            return if (email == null) null else ContactNumber(-1, email)
        }

    }
}