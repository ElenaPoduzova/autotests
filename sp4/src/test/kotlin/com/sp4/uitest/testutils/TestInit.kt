package com.sp4.uitest.testutils

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Logger
import io.github.bonigarcia.wdm.WebDriverManager
import org.testng.ITestResult
import org.testng.annotations.*

open class TestInit {
    var baseUrl: String? = null

    @BeforeTest
    fun beforeTest() {
        System.out.println("setup chromedriver")
        WebDriverManager.chromedriver().setup()
    }

    @BeforeClass
    @Throws(Exception::class)
    fun beforeClass() {
        System.out.println("before test initialization")
        baseUrl = "https://dev.sp4.sitepokupok.ru/"
        System.out.println("set base url")
        Driver.init("Chrome", baseUrl!!)
        System.out.println("init chrome driver")
        Driver.maximize()
    }

    @AfterTest
    fun afterClass() {
        //Driver.get().quit()
    }

    @AfterMethod
    @Throws(Exception::class)
    fun testCaseFailure(testResult: ITestResult) {
        actionOnFailure(testResult.getStatus(), testResult.getName())
    }

    fun GetBaseUrl(): String? {
        return baseUrl
    }

    @Throws(java.lang.Exception::class)
    fun actionOnFailure(testResult: Int, testName: String) {
        if (testResult == 2) {
            Logger.takeScreenshotToReport(testName)
            Logger.getConsoleLogs()
            Logger.getPageSource()
        }
    }
}