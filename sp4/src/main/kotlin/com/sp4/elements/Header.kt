package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import com.sp4.testdata.UserData
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class Header : AbstractContainer() {
    @FindBy(linkText = "Войти")
    private val loginButton: Button? = null

    @FindBy(css = ".navbar-brand")
    private val logo: WebElement? = null

    @FindBy(css = ".sp-header__user-menu")
    private val user: UserButton? = null

    @FindBy(css = ".sp-header__message")
    private val message: MessageButton? = null

    @FindBy(css = ".sp-header__user-count-order")
    private val cart: CartButton? = null

    @FindBy(css = ".sp-header__user-purse-amount")
    private val wallet: WalletButton? = null

    @FindBy(css = ".sp-search__input")
    private val searchField: TextField? = null

    @FindBy(css = ".sp-search__btn btn")
    private val searchButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun refresh() {
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
        Wait.elementPresence(By.cssSelector(".sp-header__user-menu"))
    }

    fun clickUserProfile() {
        user!!.clickMenuButton()
        user.clickMenuElement("Редактирование профиля")
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h1"), "Редактирование профиля"))
        //check pop up is hidden
        Thread.sleep(5000)
    }

    fun clickWalletBtn() {
        wallet!!.click()
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h1"), "Кошёлек"))
        Thread.sleep(5000)
    }

    fun getWalletCount(): Float {
        return  wallet!!.getValue()
    }
}
