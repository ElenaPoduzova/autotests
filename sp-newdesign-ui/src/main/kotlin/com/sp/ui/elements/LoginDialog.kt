package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Common
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginDialog : AbstractContainer() {
    @FindBy(css = ".modal-content form")
    private val base: WebElement? = null

    @FindBy(id = "User_login")
    private val loginField: TextField? = null

    @FindBy(id = "User_password")
    private val passwordField: TextField? = null

    @FindBy(id = "login-submit")
    private val submitButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun waitToAppear(){
        Wait.elementVisibility(base!!)
    }

    fun enterLogin(login : String){
        loginField!!.clearAndType(login)
    }

    fun enterPassword(password : String){
        passwordField!!.clearAndType(password)
    }

    fun submit(){
        submitButton!!.click()
    }

    fun commitLogin(userData: com.sp.ui.testdata.UserData?){
        loginField!!.clearAndType(userData!!.login)
        passwordField!!.clearAndType(userData!!.password)
        submitButton!!.click()
    }
}
