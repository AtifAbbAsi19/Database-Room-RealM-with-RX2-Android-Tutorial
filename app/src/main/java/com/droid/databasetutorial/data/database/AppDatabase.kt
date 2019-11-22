package com.droid.databasetutorial.data.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.droid.databasetutorial.data.dao.UserDao
import com.droid.databasetutorial.data.entity.Account
import com.droid.databasetutorial.data.entity.Address
import com.droid.databasetutorial.data.entity.ContactNumber
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.data.utils.TypeConverterUtils

@Database(entities = [User::class, Account::class, ContactNumber::class, Address::class], version = 1)
@TypeConverters(TypeConverterUtils::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


/*    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(@NonNull context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                AppDatabase::class.java, "user-database.db")
                .build()
    }*/
}

/**
 *
 *
 *https://android.jlelse.eu/android-room-using-kotlin-f6cc0a05bf23
 *
 *
 * **/