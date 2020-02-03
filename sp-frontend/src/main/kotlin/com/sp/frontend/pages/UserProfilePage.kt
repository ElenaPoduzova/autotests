package com.sp.frontend.pages

import com.tests.core.driverutils.Driver
import com.sp.frontend.elements.ListMenu
import com.sp.frontend.elements.UserDataForm
import com.tests.core.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserProfilePage : BasePage() {
    @FindBy(css="ul.sp-side-menu")
    public val profileMenu: ListMenu? = null

    @FindBy(css="li.nav-item")
    public val navs: List<WebElement>? = null

    @FindBy(css=".sp-user-data")
    val userDataForm: UserDataForm? = null

    fun open() {
        Driver.openPage("/user/profile")
    }

    fun clickNav(num: Int) {
        navs!![num].click()
    }

}