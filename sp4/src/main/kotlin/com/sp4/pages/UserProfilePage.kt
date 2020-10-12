package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.sp4.elements.ListMenu
import com.sp4.elements.UserDataForm
import com.uitestcore.elementobjects.Link
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserProfilePage : BasePage() {
    @FindBy(css=".sp-user__profile-links.sp-user__profile-item a")
    val profileMenu: List<Link>? = null

    @FindBy(css=".sp-user__personal-information.sp-user__content-item h5")
    val profileData: List<WebElement>? = null

    fun open() {
        Driver.openPage("/user/profile")
    }
}