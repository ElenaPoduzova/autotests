package com.sp4.uitest.testutils

import com.sp4.elements.Header
import com.sp4.pages.LoginPage
import com.sp4.pages.MainPage
import com.sp4.testdata.UserData
import com.uitestcore.driverutils.Driver
import org.openqa.selenium.Dimension
import org.testng.annotations.*

open class TestInitWithLogin(profile: UserData?) : TestInit() {
    private val profile = profile

    @BeforeClass
    @Throws(Exception::class)
    override  fun beforeClass() {
        Driver.init()
        Driver.get().manage().window().size = Dimension(1440, 900);
        MainPage().open()
        val header = Header()
        //Driver.setCookies(CookieProfileReader.readProfile(this.profile))
        //Driver.reloadPage()
        header.openLoginForm()
        val loginPage = LoginPage()
        loginPage.commitLogin(profile)
    }
}