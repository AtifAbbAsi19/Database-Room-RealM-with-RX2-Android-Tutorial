package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.*
import com.droid.databasetutorial.data.utils.TypeConverterUtils

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "user")
data class User(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        // @SerializedName("user_name")
        @NonNull
        @ColumnInfo(name = "user_name") var userName: String,

        @NonNull
        @ColumnInfo(name = "first_name") var firstName: String,

        @NonNull
        @ColumnInfo(name = "last_name") var lastName: String,

        @NonNull
        @ColumnInfo(name = "email") var email: String,

        //@Embedded
        @NonNull
        @Embedded(prefix = "contact_number")
        var contactNumber: ArrayList<ContactNumber>,
//        @ColumnInfo(name = "contact_number") var contactNumber: ArrayList<ContactNumber>,


        @NonNull
        @Embedded(prefix = "account_number")
        var accountNumber: ArrayList<Account>
//        @ColumnInfo(name = "account_number") var accountNumber: ArrayList<Account>
// @Ignore
) {
    constructor() : this(-1, "", "", "", "", ArrayList<ContactNumber>(), ArrayList<Account>())
}


