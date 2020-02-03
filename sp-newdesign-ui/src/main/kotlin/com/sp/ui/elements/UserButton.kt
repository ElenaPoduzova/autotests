package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Common
import com.tests.core.elementobjects.Button
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserButton : AbstractContainer() {
    @FindBy(css = ".topbar-item.nav-user img.avatar")
    private val avatar: WebElement? = null

    @FindBy(css = ".topbar-item.nav-user .dropdown-toggle")
    private val menuButton: Button? = null

    @FindBy(css = ".topbar-item.nav-user .dropdown-menu.with-arrow.show")
    private val userMenu: WebElement? = null

    @FindBy(css = "strong.title")
    private val userName: WebElement? = null

    fun getUserName() : String{
        Common.waitElementVisible(By.cssSelector(".sp-header__user-dropdown > button"))
        return userName!!.text
    }

    fun clickMenuButton() {
        menuButton!!.click()
    }

    fun clickMenuElement(link : String){
        userMenu!!.findElement(By.linkText(link)).click()
    }
}
