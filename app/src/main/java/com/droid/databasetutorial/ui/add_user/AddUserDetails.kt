package com.droid.databasetutorial.ui.add_user

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.databinding.ActivityAddUserDetailsBinding
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddUserDetails : AppCompatActivity() {


    var binding: ActivityAddUserDetailsBinding? = null

    var userName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_user_details)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_user_details)

        binding?.viewModel = UpdateUserViewModel()

        binding?.userNameEt?.addTextChangedListener(binding?.viewModel?.getUserName())

        binding?.viewModel?.setTextView(binding?.textView!!)



        binding?.updateUserBtn?.setOnClickListener(View.OnClickListener {

            Completable.fromAction {
                AppDatabase
                        .getDatabase(this).userDao().insertUser(User())

            }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // data updated

                    }

        })


    }
}
