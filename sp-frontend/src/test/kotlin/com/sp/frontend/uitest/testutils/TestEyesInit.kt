package com.sp.frontend.uitest.testutils

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.selenium.Eyes
import com.uitestcore.driverutils.Driver
import io.github.bonigarcia.wdm.WebDriverManager
import org.testng.annotations.*
import java.lang.reflect.Method

open class TestEyesInit {
    var baseUrl: String? = null
    private var batch: BatchInfo? = null
    val eyes: Eyes = Eyes()

    @BeforeTest
    fun beforeTest() {
        WebDriverManager.chromedriver().setup()
    }

    @BeforeClass
    fun beforeClass() {
        batch = BatchInfo("Sitepokupok Test")
        baseUrl = "https://frontend.dev.sitepokupok.ru"
        Driver.init("Chrome", baseUrl!!)
        Driver.openPage()
        Functions.closeCookies()
        createDriver()
    }

    @AfterTest
    fun afterClass() {
        Driver.get().quit()
    }

    protected fun createDriver() {
        eyes.apiKey = "E0Sm1kDZowqZ0rfwuMtzBxNjKGRAzvfw1W4Jksa1062Hs110"
        eyes.hideScrollbars = true
        eyes.forceFullPageScreenshot = true
        //eyes.stitchMode = StitchMode.CSS
        eyes.batch = batch
    }

    @DataProvider(name = "hardCodedViewPorts", parallel = true)
    fun viewportDataProvider(testMethod: Method?): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>(500, 600), arrayOf<Any>(768, 600), arrayOf<Any>(1360, 600))
    }
}