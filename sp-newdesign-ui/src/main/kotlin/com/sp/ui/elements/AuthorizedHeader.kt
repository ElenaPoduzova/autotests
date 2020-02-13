package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class AuthorizedHeader : AbstractContainer() {
    @FindBy(linkText = "Войти")
    private val loginButton: Button? = null

    @FindBy(css = ".topbar-logo")
    private val logo: WebElement? = null

    @FindBy(css = ".topbar-item.nav-user")
    private val user: UserButton? = null

    @FindBy(css = ".topbar-item.nav-btn")
    private val message: MessageButton? = null

    @FindBy(css = ".topbar-item.nav-btn:nth-child(2)")
    private val cart: CartButton? = null

    @FindBy(css = ".topbar-item.nav-btn:nth-child(3)")
    private val wallet: WalletButton? = null

    @FindBy(id = "text")
    private val searchField: TextField? = null

    @FindBy(css = "input[type=\"submit\"]")
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

    fun loginIs(userData: com.sp.ui.testdata.UserData?): Boolean{
        val selector = By.cssSelector(".topbar-item.nav-user .title")
        Wait.elementPresence(selector)
        return (Driver.findElement(selector).text == userData!!.name)
    }

    fun clickUserProfile() {
        user!!.clickMenuButton()
        user.clickMenuElement("Личный кабинет")
        Wait.until(ExpectedConditions.titleIs("Сайт Покупок - Профиль пользователя"))
        //check pop up is hidden
    }

    fun clickWalletBtn() {
        wallet!!.click()
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h1"), "Мой кошелёк"))
    }

    fun clickCartBtn() {
        cart!!.click()
        Wait.until(ExpectedConditions.textToBePresentInElement(Driver.getElementByCss("h1"), "Мои заказы"))
    }

    fun getWalletCount(): Float {
        return  wallet!!.getValue()
    }
}
