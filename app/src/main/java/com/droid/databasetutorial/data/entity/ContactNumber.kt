package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact_number")
class ContactNumber() {


    @PrimaryKey(autoGenerate = true)
    var id: Int = -1


    @ColumnInfo(name = "email")
    var email: String =" "


    @ColumnInfo(name = "contactNumber")
    var contactNumber: String = " "




}