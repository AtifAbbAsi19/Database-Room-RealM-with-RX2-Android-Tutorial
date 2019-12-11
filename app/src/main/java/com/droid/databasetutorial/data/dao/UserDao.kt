package com.droid.databasetutorial.data.dao

import androidx.room.*
import com.droid.databasetutorial.data.entity.User
import io.reactivex.Flowable

@Dao
interface UserDao {

    //https://medium.com/androiddevelopers/room-rxjava-acb0cd4f3757

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flowable<List<User>> //rx2 Query

    @Query("SELECT * FROM user")
    fun getAllUsersNormal(): List<User> //simple database query

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName")
    fun findByTitle(firstName: String): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg usersList: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun updateUsers(vararg usersList: User)
}