package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
 class Account {

    @PrimaryKey(autoGenerate = true)
    var id: Int = -1

    @NonNull
    @ColumnInfo(name = "email")
    var email: String?=null

    @NonNull
    @ColumnInfo(name = "accountNumber")
    var accountNumber: String?=null
}