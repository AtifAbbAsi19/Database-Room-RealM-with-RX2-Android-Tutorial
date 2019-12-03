package com.droid.databasetutorial.ui.add_user

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class UpdateUserViewModel : ViewModel() {

    /*  init {

     }*/

    //first enable data binding for ObservableField

    var userName: ObservableField<String> = ObservableField()
    var firstName: ObservableField<String> = ObservableField()
    var lastName: ObservableField<String> = ObservableField()
    var email: ObservableField<String> = ObservableField()
    var contactNumber: ObservableField<String> = ObservableField()
    var accountNumber: ObservableField<String> = ObservableField()
    var updateButtonEnable = ObservableBoolean(false)

    var view: TextView? = null


    /**
     * @Link https://android.jlelse.eu/android-data-binding-binding-adapters-part-5-2bc91e43caa0
     */
    @BindingAdapter("app:greeting")
    fun bindingAdapterExample(textView: TextView, value: String) {
        textView.text = "".plus(value)
    }


    fun setTextView(textView: TextView) {
        this.view = textView
    }

    @Bindable
     fun getUserName(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                if (!editable.isNullOrEmpty()) {
                    userName.set(editable.toString())
                    bindingAdapterExample(view!!,editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


    fun getFirstName(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                if (!editable.isNullOrEmpty()) {
                    firstName.set(editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


    fun getLastName(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {

                if (!editable.isNullOrEmpty()) {
                    lastName.set(editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


    fun getEmail(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {


                if (!editable.isNullOrEmpty()) {
                    email.set(editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


    fun getContact(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                if (!editable.isNullOrEmpty()) {
                    contactNumber.set(editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


    fun getAccountNumber(): TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {

                if (!editable.isNullOrEmpty()) {
                    accountNumber.set(editable.toString())
                    updateButtonEnable.set(true)
                } else {
                    updateButtonEnable.set(false)
                }
            }

            override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    }


}