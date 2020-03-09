package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.sp4.elements.ListMenu
import com.sp4.elements.UserDataForm
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserProfilePage : BasePage() {
    @FindBy(css="ul.sp-side-menu")
    val profileMenu: ListMenu? = null

    @FindBy(css=".nav.nav-pills li.nav-item")
    val navs: List<WebElement>? = null

    @FindBy(css=".sp-user-data")
    val userDataForm: UserDataForm? = null

    fun open() {
        Driver.openPage("/user/profile")
    }

    fun clickNav(num: Int) {
        navs!![num].click()
    }

}