package com.droid.databasetutorial.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
class Account(
        @PrimaryKey(autoGenerate = true)
        var id: Int
)