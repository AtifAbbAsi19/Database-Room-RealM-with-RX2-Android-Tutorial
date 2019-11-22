package com.droid.databasetutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.ContactNumber
import com.droid.databasetutorial.data.entity.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//AppDatabase.getDatabase(this).userDao().insertUser()
//todo getting error on type convertor
        /**
         * A field can be annotated with only one of the following:ColumnInfo,Embedded,Relation
        private java.util.ArrayList<com.droid.databasetutorial.data.entity.ContactNumber> contactNumber;

        consider adding a type converter for it.
        private java.util.ArrayList<com.droid.databasetutorial.data.entity.Account> accountNumber;

         */

    }//end of on create

}//end of class
