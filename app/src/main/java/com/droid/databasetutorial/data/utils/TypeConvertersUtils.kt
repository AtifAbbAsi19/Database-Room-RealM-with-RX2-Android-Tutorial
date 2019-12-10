package com.droid.databasetutorial.data.utils

import androidx.room.TypeConverter
import com.droid.databasetutorial.data.entity.Account
import com.droid.databasetutorial.data.entity.Address
import com.droid.databasetutorial.data.entity.ContactNumber
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class TypeConvertersUtils {


    /**
     * @Link developer.android.com/reference/android/arch/persistence/room/TypeConverters
     */

    companion object{

        val gson = Gson()

        @JvmStatic
        @TypeConverter
        fun toAddress(email: String): Address? {
            return if (email == null) null else Address()
        }

        @JvmStatic
        @TypeConverter
        fun toContactNumber(email: String): ContactNumber? {
            return if (email == null) null else ContactNumber()
        }


        @JvmStatic
        @TypeConverter
        fun accountArrayListToJson(list: List<Account>?): String? {
            return if(list == null) null else gson.toJson(list)
        }
        @JvmStatic
        @TypeConverter
        fun accountJsonToArrayList(jsonData: String?): List<Account>? {
            return if (jsonData == null) null else gson.fromJson(jsonData, object : TypeToken<List<Account>?>() {}.type)
        }
        @JvmStatic
        @TypeConverter
        fun contactNumberArrayListToJson(list: List<ContactNumber>?): String? {
            return if(list == null) null else gson.toJson(list)
        }
        @JvmStatic
        @TypeConverter
        fun contactNumberJsonToArrayList(jsonData: String?): List<ContactNumber>? {
            return if (jsonData == null) null else gson.fromJson(jsonData, object : TypeToken<List<ContactNumber>?>() {}.type)
        }

    }
}