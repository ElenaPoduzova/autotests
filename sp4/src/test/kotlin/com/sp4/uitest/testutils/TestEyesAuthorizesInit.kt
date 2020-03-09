package com.sp4.uitest.testutils

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.selenium.Eyes
import com.applitools.eyes.selenium.StitchMode
import com.sp4.testdata.UsersList.USER
import com.uitestcore.driverutils.Driver
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.ITestResult
import org.testng.annotations.*
import java.lang.reflect.Method
import java.net.MalformedURLException
import java.rmi.UnexpectedException

open class TestEyesAuthorizesInit {
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
        Functions.logIn(USER!!)
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