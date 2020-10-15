package com.sp4.uitest.testutils

import com.sp4.pages.MainPage
import com.uitestcore.driverutils.CookieProfileReader
import com.uitestcore.driverutils.Driver
import org.openqa.selenium.Dimension
import org.testng.annotations.*

open class TestInitWithLogin(profile : String) : TestInit() {
    private val profile = profile

    @BeforeClass
    @Throws(Exception::class)
    override  fun beforeClass() {
        Driver.init()
        Driver.get().manage().window().size = Dimension(1440, 900);
        MainPage().open()
        Driver.setCookies(CookieProfileReader.readProfile(this.profile))
        Driver.reloadPage()
    }
}