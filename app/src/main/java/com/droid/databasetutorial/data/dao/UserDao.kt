package com.droid.databasetutorial.data.dao

import androidx.room.*
import com.droid.databasetutorial.data.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

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