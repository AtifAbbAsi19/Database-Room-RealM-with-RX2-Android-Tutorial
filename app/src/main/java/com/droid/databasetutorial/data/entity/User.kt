package com.droid.databasetutorial.data.entity

import androidx.annotation.NonNull
import androidx.room.*
import kotlin.collections.ArrayList

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "user")
class User {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    /*     @PrimaryKey
         @ColumnInfo(name = "id")
         var id: String = UUID.randomUUID().toString()*/

    // @SerializedName("user_name")
    @NonNull
    @ColumnInfo(name = "user_name")
    var userName: String = " "

    @NonNull
    @ColumnInfo(name = "first_name")
    var firstName: String = " "

    @NonNull
    @ColumnInfo(name = "last_name")
    var lastName: String = " "

    @NonNull
    @ColumnInfo(name = "email")
    var email: String = " "

    /**
     * @Embedded
     * https://developer.android.com/reference/android/arch/persistence/room/Embedded
     */


    @Embedded(prefix = "contact_number")
    var simpleContactNumber: ContactNumber? = null


    //    @Relation(parentColumn = "id", entityColumn = "email")
    @ColumnInfo(name = "contactNumber")
    var contactNumber: List<ContactNumber> = ArrayList()
//        @ColumnInfo(name = "contact_number") var contactNumber: ArrayList<ContactNumber>,


    @Embedded(prefix = "account_number")
    var simpleAccountNumber: Account? = null


    //    @Relation(parentColumn = "id", entityColumn = "email")
    @ColumnInfo(name = "accountNumber")
    var accountNumber: List<Account> = ArrayList()
//        @ColumnInfo(name = "account_number") var accountNumber: ArrayList<Account>
// @Ignore


//    constructor() : this(-1, "", "", "", "", ArrayList<ContactNumber>(), ArrayList<Account>())

}


