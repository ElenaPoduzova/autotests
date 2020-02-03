package com.sp.ui.pages

import com.tests.core.driverutils.Driver
import com.tests.core.pageobjects.BasePage
import com.sp.ui.elements.UserDataTable
import org.openqa.selenium.support.FindBy

class UserProfilePage : BasePage() {
    @FindBy(css="table.userData")
    val userData: UserDataTable? = null

    fun open() {
        Driver.openPage("/user/profile")
    }
}