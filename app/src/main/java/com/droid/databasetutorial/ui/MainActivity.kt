package com.droid.databasetutorial.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.ui.add_user.AddUserDetails
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {


    var userList: List<User> = ArrayList()
    var userListNormal: List<User> = ArrayList()

    var disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addUserTextView: TextView = this.findViewById(R.id.addUser)


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
         *    io.reactivex import
         *
         *
         * @link https://blog.gojekengineering.com/multi-threading-like-a-boss-in-android-with-rxjava-2-b8b7cf6eb5e2
         *
         * @link https://codinginfinite.com/android-room-persistent-rxjava/
         *
         * @link https://stackoverflow.com/questions/55623588/incorrect-code-generation-from-room-query-when-using-flowable-observable
         *
         * @link  https://medium.com/@alahammad/database-with-room-using-rxjava-764ee6124974

         */


        disposable.addAll(

                AppDatabase.getDatabase(this).userDao().getAllUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            updateList(it)
                            /*    Consumer<List<User>> { list ->
                                    userList = list

                                }//end of accept method*/
                            //end of consumer


                        }//end of subscribe

        )//end of disposable

        /**
         *
         * @param Iterable_Operator
         * Iterable takes a list of object and convert them into Observable
         *
         * @link https://stackoverflow.com/questions/40323307/observable-vs-flowable-rxjava2/40326875
         *
         * @link https://eng.uber.com/rxjava-backpressure/
         *
         * observable (publisher)
         */


        /**
         * @exception  java.lang.IllegalStateException:
         * Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
         */
        disposable.addAll( //addAll

                Observable.fromIterable(AppDatabase.getDatabase(this).userDao().getAllUsersNormal())//operator
                        .subscribeOn(Schedulers.io()) //where the work is going to be done #worker_thread
                        .observeOn(AndroidSchedulers.mainThread()) // what thread to observe on(return data to main thread)
                        .subscribe {
                            object : Observer<User> {
                                override fun onComplete() {
                                    Toast.makeText(applicationContext, "Completed : List Size: ".plus(userListNormal.size), Toast.LENGTH_LONG).show()
                                }//end of onComplete
                                override fun onSubscribe(d: Disposable) {
                                    disposable.add(d)
                                    Log.d("Main", "onSubscribe Called")
                                }//end of onSubscribe
                                override fun onNext(t: User) {
                                    if (null != it) {
                                        userListNormal = arrayListOf(it)
                                    }//end of if

                                    Log.d("Main", "OnNext Called")
                                    Log.d("Main", "OnNext Result : ".plus(it.toString()))
                                }//onNext
                                override fun onError(e: Throwable) {
                                    Log.d("Main", "onError Called")
                                    Log.d("Main", "onError Message : ".plus(e.message))
                                }//onError

                            }
                        }


        )//end of disposable


        /*

        crashing

        disposable.addAll(

                      Observable.
                              fromIterable(AppDatabase.getDatabase(this).userDao().getAllUsersNormal())
                              .subscribeOn(Schedulers.io()) //where the work is going to be done #worker_thread
                              .observeOn(AndroidSchedulers.mainThread()) // what thread to observe on
                              .subscribe {


                                  if (null != it) {
                                      userListNormal = arrayListOf(it)
                                      if (null != userListNormal && userListNormal.isNotEmpty()) { //null and empty check
                                          Toast.makeText(applicationContext, "User List Size : ".plus(userListNormal.size), Toast.LENGTH_LONG).show()

                                      } else {
                                          Toast.makeText(applicationContext, "No Record Found ", Toast.LENGTH_LONG).show()
                                      }
                                  } else {
                                      Toast.makeText(applicationContext, "Object is Null ", Toast.LENGTH_LONG).show()

                                  }


                              }//end of subscribe
              )//end of dispossible */


//        userList = AppDatabase.getDatabase(this).userDao().getAllUsers()

        addUserTextView.text = "Add User"
        addUserTextView.setOnClickListener { startActivity(Intent(applicationContext, AddUserDetails::class.java)) }


    }//end of on create

    private fun updateList(it: List<User>?) {

        if (null != it && it.isNotEmpty()) { //null and empty check
            userList = it
            Toast.makeText(applicationContext, "User List Size : ".plus(userList.size), Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(applicationContext, "No Record Found ", Toast.LENGTH_LONG).show()
        }

    }


}//end of class
