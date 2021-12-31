package com.assignment.week_5_task_hakeemanimashaun

import java.util.regex.Pattern

object RegistrationFormUtil {
    fun validateRegistrationInput(
        name: String,
        email: String,
        mobile: String,
        sex: String
    ): Boolean {
         return (name.isBlank() && email.isBlank() && mobile.isBlank() && sex.isBlank())
    }

    fun checkName(name: String,
                  email: String,
                  mobile: String,
                  sex: String): Boolean{
        return Pattern.compile("/^[a-zA-Z]{2,}\\s[a-zA-Z]+/i").matcher(name).matches()

        }
    fun isEmailValid(name: String,
                     email: String,
                     mobile: String,
                     sex: String): Boolean {
        return Pattern.compile(
            "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$").matcher(email).matches()
    }
    fun checkMobile(name: String,
                    email: String,
                    mobile: String,
                    sex: String,): Boolean{
            return Pattern.compile(
                "^(234|0)(8([01])|(9([01]))|([7])([0]))\\d{8}$"
            ).matcher(mobile).matches()
        }

}
