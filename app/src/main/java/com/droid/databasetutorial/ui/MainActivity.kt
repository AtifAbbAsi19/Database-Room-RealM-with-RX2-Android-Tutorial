package com.droid.databasetutorial.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.ui.add_user.AddUserDetails


class MainActivity : AppCompatActivity() {


    var userList: List<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addUserTextView: TextView = this.findViewById(R.id.addUser)

        /**
         *  Insert and get data using Database Async way
         */



        /*     Thread(Runnable {

                 userList = AppDatabase.getDatabase(this).userDao().getAllUsers()

             }).start()*/

        userList = AppDatabase.getDatabase(this).userDao().getAllUsers()

        addUserTextView.text = "Add User"
        addUserTextView.setOnClickListener { startActivity(Intent(applicationContext, AddUserDetails::class.java)) }


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
