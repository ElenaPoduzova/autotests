package com.sp.frontend.uitest.eyestests

import com.applitools.eyes.RectangleSize
import com.uitestcore.driverutils.Driver
import org.testng.annotations.Test
import com.sp.frontend.uitest.testutils.TestEyesAuthorizesInit

class AuthorizedMainPageEyesTest : TestEyesAuthorizesInit() {
    val pages = mapOf<String, String>( "Main" to "/", "News" to "/news", "Boast all" to "/boast/boast-all", "Stock list active" to "/stock/active",
            "Cart" to "/cart/active", "Purse" to "/purse" )

    @Test
    fun verifyDesignAuthorized500() {
        this.eyes.open(Driver.get(), "SPFrontend", "SPFrontend Authorized Pages", RectangleSize(500, 700))
        for (page in pages) {
            Driver.openPage(page.component2())
            this.eyes.checkWindow(page.component1())
        }
        this.eyes.close(false)
    }
}