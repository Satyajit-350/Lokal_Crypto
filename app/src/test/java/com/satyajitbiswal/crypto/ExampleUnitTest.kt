package com.satyajitbiswal.crypto

import com.satyajitbiswal.crypto.utils.Utils
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun isValidatePassword_blankInput_expectedRequiredField(){
        //sut -> system under test
        val sut = Utils()
        val result = sut.validatePassword("")
        Assert.assertEquals("Password is required field", result)
    }


    @Test
    fun isValidatePassword_2CharInput_expectedValidationMessage(){
        //sut -> system under test
        val sut = Utils()
        val result = sut.validatePassword("ab")
        Assert.assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun isValidatePassword_15Char_expectedValidationMessage(){
        //sut -> system under test
        val sut = Utils()
        val result = sut.validatePassword("Password123PasswordSatyajitihgdkhb")
        Assert.assertEquals("Length of the password is be greater than 15", result)
    }


    @Test
    fun isValidatePassword_validInput_expectedValidPassword(){
        //sut -> system under test
        val sut = Utils()
        val result = sut.validatePassword("Password123")
        Assert.assertEquals("Valid", result)
    }

}