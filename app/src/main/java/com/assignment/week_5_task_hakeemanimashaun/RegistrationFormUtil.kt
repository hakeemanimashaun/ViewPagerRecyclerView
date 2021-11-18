package com.assignment.week_5_task_hakeemanimashaun

import android.widget.Toast
import java.util.regex.Pattern

object RegistrationFormUtil {
    fun validateRegistrationInput(
        name: String,
        email: String,
        mobile: String,
        sex: String,
    ): Boolean{
     return true
    }
    fun checkName(string: String): Boolean{
        return Pattern.compile("/^[a-z ,.'-]+$/i").matcher(string).matches()

        }
    fun isEmailValid(string: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(string).matches()
    }
    fun checkMobile(string: String): Boolean{
            return Pattern.compile(
                "/^(\\\\\\\\+234|0)(8([01])|([79])([0]))\\\\\\\\d{8}\\\$\"/i"
            ).matcher(string).matches()
        }

}
