package com.sp4.uitest.testutils

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Logger
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.testng.ITestResult
import org.testng.annotations.*

open class TestInit {
    var baseUrl: String? = null

    @BeforeClass
    @Throws(Exception::class)
    fun beforeClass() {
        Driver.init()
        //Driver.maximize()
        Driver.get().manage().window().size = Dimension(1440, 900);
    }

    @AfterTest
    fun afterClass() {
        Driver.get().quit()
    }

    @AfterMethod
    @Throws(Exception::class)
    fun testCaseFailure(testResult: ITestResult) {
        actionOnFailure(testResult.getStatus(), testResult.getName())
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