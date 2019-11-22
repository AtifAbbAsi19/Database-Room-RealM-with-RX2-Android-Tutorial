package com.droid.databasetutorial.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.droid.databasetutorial.data.entity.Account
import com.droid.databasetutorial.data.entity.ContactNumber

@Entity(tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "user_name") var userName: String,
        @ColumnInfo(name = "first_name") var firstName: String,
        @ColumnInfo(name = "last_name") var lastName: String,
        @ColumnInfo(name = "email") var email: String,
        @ColumnInfo(name = "contactNumber") var contactNumber: List<ContactNumber>,
        @ColumnInfo(name = "accountNumber") var accountNumber: List<Account>
)