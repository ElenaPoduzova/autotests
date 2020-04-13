package com.sp4.uitest.testutils

import com.sp4.elements.Header
import com.sp4.pages.LoginPage
import com.sp4.pages.MainPage
import com.sp4.testdata.UsersList
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Logger
import io.github.bonigarcia.wdm.WebDriverManager
import org.testng.ITestResult
import org.testng.annotations.*

open class TestInitWithLogin {
    var baseUrl: String? = null

    @BeforeTest
    fun beforeTest() {
        WebDriverManager.chromedriver().setup()
    }

    @BeforeClass
    @Throws(Exception::class)
    fun beforeClass() {
        baseUrl = "https://dev.sp4.sitepokupok.ru/"
        Driver.init("Chrome", baseUrl!!)
        Driver.maximize()
        val header = Header()
        MainPage().open()
        header.openLoginForm()
        val loginPage = LoginPage()
        loginPage.commitLogin(UsersList.ORG)
        header.loginIs(UsersList.ORG)
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