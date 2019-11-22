package com.droid.databasetutorial.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact_number")
class ContactNumber(
        @PrimaryKey(autoGenerate = true)
        var id: Int
)