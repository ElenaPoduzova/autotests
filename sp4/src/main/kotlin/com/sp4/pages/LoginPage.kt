package com.sp4.pages

import com.sp4.elements.MonetaPayForm
import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage
import com.sp4.elements.WalletBalanceForm
import com.sp4.testdata.CardsList.CORRECTCARD
import com.sp4.testdata.UserData
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginPage : BasePage() {
    @FindBy(css = "form")
    private val base: WebElement? = null

    @FindBy(id = "UserLoginForm_login")
    private val loginField: TextField? = null

    @FindBy(id = "UserLoginForm_password")
    private val passwordField: TextField? = null

    @FindBy(css = "#UserLoginForm button")
    private val submitButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object {
        fun open() {
            Driver.openPage("/user/login")
            Wait.elementPresence(By.id("UserLoginForm_login"))
        }
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
        passwordField!!.clearAndType(userData.password)
        submitButton!!.click()
        Wait.elementPresence(By.xpath("//span/span[@class='sp-user ' and contains(text(), '${userData!!.login}')]"))
    }
}