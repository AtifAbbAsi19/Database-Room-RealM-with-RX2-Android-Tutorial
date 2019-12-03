package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact_number")
class ContactNumber() {


    @PrimaryKey(autoGenerate = true)
    var id: Int = -1

    @NonNull
    @ColumnInfo(name = "email")
    var email: String? = null

    @NonNull
    @ColumnInfo(name = "contactNumber")
    var contactNumber: String? = null
//    constructor():this()

}