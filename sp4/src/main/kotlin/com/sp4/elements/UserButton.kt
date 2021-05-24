package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Common
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserButton : AbstractContainer() {
    @FindBy(css = ".sp-avatar")
    private val avatar: WebElement? = null

    @FindBy(css = "#sp-user-menu-dropdown")
    private val menuButton: Button? = null

    @FindBy(css = ".show:nth-child(3)")
    private val userMenu: WebElement? = null

    @FindBy(css = ".sp-user")
    private val userName: WebElement? = null

    fun getUserName() : String{
        Common.waitElementVisible(By.cssSelector(".sp-user"))
        return userName!!.text
    }

    fun clickMenuButton() {
        menuButton!!.click()
    }

    fun clickMenuElement(link : String){
        (userMenu!!.findElement(By.linkText(link))).click()
    }
}
