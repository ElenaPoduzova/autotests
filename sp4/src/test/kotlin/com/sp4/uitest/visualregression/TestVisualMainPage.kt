package com.sp4.uitest.visualregression

import com.sp4.elements.Header
import com.sp4.functions.SharedFunctions
import com.sp4.functions.UserFunctions
import com.sp4.pages.LoginPage
import com.sp4.pages.MainPage
import com.sp4.testdata.UsersList
import com.sp4.uitest.testutils.TestInitVrt
import com.sp4.uitest.testutils.VisualTestInit
import com.uitestcore.annotation.VisualTestStep
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ScreenshotUtils
import io.visual_regression_tracker.sdk_java.TestRunOptions
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestVisualMainPage : VisualTestInit() {

    /*@Test(priority = 1, dataProvider = "browserParamsData")
    fun loginPageTest(width: Int, height: Int, options: TestRunOptions) {
        Driver.get().manage().window().size = Dimension(width, height)
        LoginPage.open()
        var test1 = (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64)
        vrt.track(
                "Login Page",
                test1,
                options
        )
    }*/

    @Test(dataProvider = "unauthorizedPagesData")
    fun testMainPage(page: VisualPage) {
        Driver.openPage()
        Driver.get().manage().window().size = Dimension(page.resolution.first, page.resolution.second)
        ScreenshotUtils.takeAndSaveFullScreenshot("${page.screenName}_${page.resolution.first}_${page.resolution.second}", "ExpectedScreenshots")
        logResult("${page.screenName}_${page.resolution.first}_${page.resolution.second}", ScreenshotUtils.compareScreenshots("${page.screenName}_${page.resolution.first}_${page.resolution.second}"))
    }

    /*@VisualTestStep(screenName = "mainPage")
    @Test(priority=1)
    fun testMainPage() {
        val assert = SoftAssert()
        Driver.openPage()
        //ScreenshotUtils.takeAndSaveFullScreenshot("mainPage", "ExpectedScreenshots")
        assert.assertTrue(ScreenshotUtils.compareScreenshots("mainPage"))
        assert.assertAll()
    }

    @VisualTestStep(screenName = "loginPage")
    @Test(priority=2)
    fun testLoginPage() {
        val assert = SoftAssert()
        Driver.openPage("user/login")
        //ScreenshotUtils.takeAndSaveFullScreenshot("loginPage", "ExpectedScreenshots")
        assert.assertTrue(ScreenshotUtils.compareScreenshots("loginPage"))
        assert.assertAll()
    }

    @VisualTestStep(screenName = "pursePage")
    @Test(priority=3)
    fun testPursePage() {
        UserFunctions.loginAsUser(UsersList.USER!!)
        val assert = SoftAssert()
        Driver.openPage("purse")
        ScreenshotUtils.takeAndSaveFullScreenshot("pursePage", "ExpectedScreenshots")
        assert.assertTrue(ScreenshotUtils.compareScreenshots("pursePage"))
        assert.assertAll()
    }

    @VisualTestStep(screenName = "cartPage")
    @Test(priority=4)
    fun testCartPage() {
        val assert = SoftAssert()
        Driver.openPage("cart")
        ScreenshotUtils.takeAndSaveFullScreenshot("cartPage", "ExpectedScreenshots")
        assert.assertTrue(ScreenshotUtils.compareScreenshots("cartPage"))
        assert.assertAll()
    }

    @VisualTestStep(screenName = "stockPage")
    @Test(priority=5)
    fun testStockPage() {
        val assert = SoftAssert()
        Driver.openPage("stock/207-podari-eto-mne-1")
        ScreenshotUtils.takeAndSaveFullScreenshot("stockPage", "ExpectedScreenshots")
        assert.assertTrue(ScreenshotUtils.compareScreenshots("stockPage"))
        assert.assertAll()
    }*/

    @DataProvider(name = "unauthorizedPagesData")
    fun unauthorizedPagesData(): MutableIterator<VisualPage> {
        val testData: ArrayList<VisualPage> = arrayListOf()

        val case1 = arrayOf("mainPage", "")
        val case2 = arrayOf("loginPage", "user/login")

        testData.add(VisualPage("mainPage", "", Pair(320, 1080)))
        testData.add(VisualPage("mainPage", "", Pair(768, 1080)))
        testData.add(VisualPage("mainPage", "", Pair(1360, 1080)))

        testData.add(VisualPage("loginPage", "user/login", Pair(320, 1080)))
        testData.add(VisualPage("loginPage", "user/login", Pair(768, 1080)))
        testData.add(VisualPage("loginPage", "user/login", Pair(1360, 1080)))


        return testData.iterator()
    }

    @DataProvider(name = "authorizedPagesData")
    fun pagesData(): MutableIterator<Array<String>> {
        val testData: ArrayList<Array<String>> = arrayListOf()

        val case1 = arrayOf("pursePage", "purse")
        val case2 = arrayOf("cartPage", "cart")
        val case3 = arrayOf("stockPage", "stock/207-podari-eto-mne-1")

        testData.add(case1)
        testData.add(case2)
        testData.add(case3)

        return testData.iterator()
    }
}