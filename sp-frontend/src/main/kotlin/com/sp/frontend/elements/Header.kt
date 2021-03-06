package com.sp.frontend.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import com.sp.frontend.testdata.UserData
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class Header : AbstractContainer() {
    @FindBy(linkText = "Войти")
    private val loginButton: Button? = null

    @FindBy(css = ".sp-header__column.sp-header__column--logo")
    private val logo: WebElement? = null

    @FindBy(css = ".sp-header__column--user")
    private val user: UserButton? = null

    @FindBy(css = ".sp-header__column--message")
    private val message: MessageButton? = null

    @FindBy(css = ".sp-header__column--cart")
    private val cart: CartButton? = null

    @FindBy(css = ".sp-header__column--wallet")
    private val wallet: WalletButton? = null

    @FindBy(id = "text")
    private val searchField: TextField? = null

    @FindBy(css = "input[type=\"submit\"]")
    private val searchButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun openLoginForm() {
        loginButton!!.click()
    }

    fun search(query: String) {
        searchField!!.clearAndType(query)
        searchButton!!.click()
    }

    fun getUserName() : String{
        return user!!.getUserName()
    }

    fun loginIs(userData: UserData?){
        Wait.elementPresence(By.cssSelector(".sp-header__column--user div button"))
    }

    fun clickUserProfile() {
        user!!.clickMenuButton()
        user.clickMenuElement("Личный кабинет")
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h2.sp-page__header"), "Личный кабинет"))
        //check pop up is hidden
        Thread.sleep(5000)
    }

    fun clickWalletBtn() {
        wallet!!.click()
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h4.sp-purse__header"), "Пополнение кошелька"))
        Thread.sleep(5000)
    }

    fun getWalletCount(): Float {
        return  wallet!!.getValue()
    }
}
