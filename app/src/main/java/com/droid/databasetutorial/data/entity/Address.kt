package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "address")
 class Address {


    //var id: String = UUID.randomUUID().toString()

    @NonNull
    @ColumnInfo(name = "email")
    var email: String? = null

    @PrimaryKey(autoGenerate = true)
    var id: Int = -1


}

/*
@NonNull
@ColumnInfo(name = "city") var city: String,

@NonNull
@ColumnInfo(name = "street_number") var streetNumber: String,

@NonNull
@ColumnInfo(name = "postal_code") var postalCode: String,

@NonNull
@ColumnInfo(name = "is_official_address") var officialAddress: Boolean*/
