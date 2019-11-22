package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @NonNull
        @ColumnInfo(name = "user_name") var userName: String,

        @NonNull
        @ColumnInfo(name = "first_name") var firstName: String,

        @NonNull
        @ColumnInfo(name = "last_name") var lastName: String,

        @NonNull
        @ColumnInfo(name = "email") var email: String,

        @NonNull
        @ColumnInfo(name = "contact_number") var contactNumber: List<ContactNumber>,

        @NonNull
        @ColumnInfo(name = "account_number") var accountNumber: List<Account>
)