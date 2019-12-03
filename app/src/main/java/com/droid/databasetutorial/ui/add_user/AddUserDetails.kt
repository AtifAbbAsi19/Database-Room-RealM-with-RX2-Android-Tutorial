package com.droid.databasetutorial.ui.add_user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.databasetutorial.R
import com.droid.databasetutorial.databinding.ActivityAddUserDetailsBinding

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


    }
}
