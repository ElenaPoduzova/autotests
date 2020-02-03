package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Common
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.TextField
import com.sp.frontend.testdata.UserData
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginDialog : AbstractContainer() {
    @FindBy(css = "form")
    private val base: WebElement? = null

    @FindBy(name = "login")
    private val loginField: TextField? = null

    @FindBy(name = "password")
    private val passwordField: TextField? = null

    @FindBy(css = "button[type=\"submit\"]")
    private val submitButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun waitToAppear(){
        Common.waitElementVisible(By.cssSelector(".modal-content"))
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

    fun commitLogin(userData: UserData?){
        loginField!!.clearAndType(userData!!.login)
        passwordField!!.clearAndType(userData!!.password)
        submitButton!!.click()
    }
}
