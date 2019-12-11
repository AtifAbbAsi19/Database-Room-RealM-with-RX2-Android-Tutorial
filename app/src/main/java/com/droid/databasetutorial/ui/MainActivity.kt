package com.droid.databasetutorial.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.ui.add_user.AddUserDetails
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {


    var userList: List<User> = ArrayList()

    var disposable: CompositeDisposable = CompositeDisposable()

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
        //https://medium.com/@alahammad/database-with-room-using-rxjava-764ee6124974

/*
        var observableArrayList = Observable
                .fromIterable(AppDatabase.getDatabase(this).userDao().getAllUsers())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe {


                *//*    t: User? ->
                    if (null != t)
                        userList = arrayListOf(t)*//*

                }*/

        /**
         * Hands on Rx2 Android
         *
         * 1) Create an Observable
         * 2) Apply an Operator to the Observable
         * 3) Designate what thread to do the work on and what thread to emit the result to
         * 4) Subscribe an Observer to the Observable and View Result
         *
         *
         * @link https://blog.gojekengineering.com/multi-threading-like-a-boss-in-android-with-rxjava-2-b8b7cf6eb5e2
         *
         * @link https://codinginfinite.com/android-room-persistent-rxjava/
         *
         * @link https://stackoverflow.com/questions/55623588/incorrect-code-generation-from-room-query-when-using-flowable-observable
         */


        /*    Observable.fromIterable(AppDatabase.getDatabase(this).userDao().getAllUsersNormal())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .s
    */


        disposable.addAll(
                AppDatabase.getDatabase(this).userDao().getAllUsers()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            userList=it

                            if (null != userList && userList.isNotEmpty()) { //null and empty check
                                Toast.makeText(applicationContext,"User List Size : ".plus(userList.size),Toast.LENGTH_LONG).show()

                            }else{
                                Toast.makeText(applicationContext,"No Record Found ",Toast.LENGTH_LONG).show()
                            }


                        /*    Consumer<List<User>> { list ->
                                userList = list

                            }//end of accept method*/
                            //end of consumer


                        }//end of subscribe

        )//end of disposable



//        userList = AppDatabase.getDatabase(this).userDao().getAllUsers()

        addUserTextView.text = "Add User"
        addUserTextView.setOnClickListener { startActivity(Intent(applicationContext, AddUserDetails::class.java)) }


    }//end of on create

}//end of class
