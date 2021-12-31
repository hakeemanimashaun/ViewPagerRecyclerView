package com.assignment.week_5_task_hakeemanimashaun


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationFormUtilTest{
    @Test
    fun `empty username field return false`(){
  val result = RegistrationFormUtil.validateRegistrationInput(
      "",
      "hakeeem@gmail.com",
      "+2345789099856",
      "female"
  )
        assertThat(result).isFalse()
    }


    @Test
    fun `invalid phone return false`(){
        val result = RegistrationFormUtil.checkMobile(
            "aging gigagray",
            "hakeeem@gmail.com",
            "5789099856",
            "female"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `invalid email format return false`(){
        val result = RegistrationFormUtil.isEmailValid(
            "aging gigagray",
            "Hakeem.com",
            "+2345789099856",
            "female"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `name without lastname returns false`(){
        val result = RegistrationFormUtil.checkName(
            "aging",
            "hakeeem@gmail.com",
            "+2345789099856",
            "female"
        )
        assertThat(result).isFalse()
    }



}