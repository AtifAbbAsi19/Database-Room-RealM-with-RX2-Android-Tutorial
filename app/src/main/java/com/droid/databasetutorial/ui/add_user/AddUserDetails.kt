package com.droid.databasetutorial.ui.add_user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.databasetutorial.R
import com.droid.databasetutorial.data.database.AppDatabase
import com.droid.databasetutorial.data.entity.Account
import com.droid.databasetutorial.data.entity.ContactNumber
import com.droid.databasetutorial.data.entity.User
import com.droid.databasetutorial.databinding.ActivityAddUserDetailsBinding
import com.droid.databasetutorial.utils.ValidatorUtils
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AddUserDetails : AppCompatActivity() {


    var binding: ActivityAddUserDetailsBinding? = null

    var userName: String? = null

    var disposable: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_user_details)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_user_details)

        binding?.viewModel = UpdateUserViewModel()

        binding?.userNameEt?.addTextChangedListener(binding?.viewModel?.getUserName())

        binding?.viewModel?.setTextView(binding?.textView!!)



        binding?.updateUserBtn?.setOnClickListener {
            validateUser()//validate user
        }

    }


    fun validateUser() {

        var user = User()

        if (binding?.userNameEt?.text != null && ValidatorUtils.hasValue(binding?.userNameEt?.text.toString())) {
            user.userName = binding?.userNameEt?.text.toString()
        } else {
            user.userName = ""
        }

        if (binding?.firstNameEt?.text != null && ValidatorUtils.hasValue(binding?.firstNameEt?.text.toString())) {
            user.firstName = binding?.firstNameEt?.text.toString()
        } else {
            user.firstName = ""
        }

        if (binding?.secondNameEt?.text != null && ValidatorUtils.hasValue(binding?.secondNameEt?.text.toString())) {
            user.lastName = binding?.secondNameEt?.text.toString()
        } else {
            user.lastName = ""
        }


        if (binding?.emailEt?.text != null && ValidatorUtils.hasValue(binding?.emailEt?.text.toString())) {
            user.email = binding?.emailEt?.text.toString()
        } else {
            user.email = ""
        }


        if (binding?.contactNumberEt?.text != null && ValidatorUtils.hasValue(binding?.contactNumberEt?.text.toString())) {
            var contactNumber = ContactNumber()
            contactNumber.email=user.email
            contactNumber.contactNumber = binding?.contactNumberEt?.text.toString()
            user.contactNumber.add(contactNumber)
        } else {
            user.contactNumber.add(ContactNumber())
        }

        if (binding?.accountNumberEt?.text != null && ValidatorUtils.hasValue(binding?.accountNumberEt?.text.toString())) {
            var account = Account()
            account.email=user.email
            account.accountNumber = binding?.accountNumberEt?.text.toString()
            user.accountNumber.add(account)
        } else {
            user.accountNumber.add(Account())
        }

        storeUserRecord(user)


    }//end of Validate User


    fun storeUserRecord(@NonNull user: User) {

        disposable.add(Completable.fromAction {
            AppDatabase.getDatabase(this).userDao().insertUser(user)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
                }
        )

    }//end of user Added


    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}
