package com.sp.frontend.uitest.eyestests

import com.applitools.eyes.RectangleSize
import com.sp.frontend.uitest.testutils.TestEyesInit
import com.uitestcore.driverutils.Driver
import org.testng.annotations.Test

class MainPageEyesTest : TestEyesInit() {
    val pages = mapOf<String, String>( "Main" to "/", "News" to "/news", "Boast all" to "/boast/boast-all", "Stock list active" to "/stock/active")

    @Test
    fun verifyDesignAnonim500() {
        this.eyes.open(Driver.get(), "SPFrontend", "SPFrontend Anonim Pages 500", RectangleSize(500, 700))
        for (page in pages) {
            Driver.openPage(page.component2())
            this.eyes.checkWindow(page.component1())
        }
        this.eyes.close(false)
    }

    @Test
    fun verifyDesignAnonim780() {
        this.eyes.open(Driver.get(), "SPFrontend", "SPFrontend Anonim Pages 780", RectangleSize(780, 700))
        for (page in pages) {
            Driver.openPage(page.component2())
            this.eyes.checkWindow(page.component1())
        }
        this.eyes.close(false)
    }

    @Test
    fun verifyDesignAnonim1360() {
        this.eyes.open(Driver.get(), "SPFrontend", "SPFrontend Anonim Pages 1360", RectangleSize(1360, 700))
        for (page in pages) {
            Driver.openPage(page.component2())
            this.eyes.checkWindow(page.component1())
        }
        this.eyes.close(false)
    }
}