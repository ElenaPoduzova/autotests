package com.sp4.uitest.visualregression

import com.sp4.functions.UserFunctions
import com.sp4.pages.StockPage
import com.sp4.testdata.OrderList.BOOTS
import com.sp4.testdata.UsersList.USER
import com.sp4.uitest.testutils.TestInitVrt
import com.uitestcore.driverutils.Driver
import io.visual_regression_tracker.sdk_java.TestRunOptions
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class TestVisualStockPage : TestInitVrt() {
    @BeforeMethod
    fun beforeMethod() {
        Driver.openPage()
        UserFunctions.loginIfUnauthorized(USER!!)
    }

    @Test(priority = 1, dataProvider = "browserParamsData")
    fun stockViewPage(width: Int, height: Int, options: TestRunOptions) {
        Driver.get().manage().window().size = Dimension(width, height)
        StockPage.open("261-avtomaticheski-sozdannaya-zakupka-2020-11-05")
        vrt.track(
                "Stock Page",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
    }

    @Test(priority = 2, dataProvider = "browserParamsData")
    fun stockViewPageRows(width: Int, height: Int, options: TestRunOptions) {
        Driver.get().manage().window().size = Dimension(width, height)
        StockPage.open("261-avtomaticheski-sozdannaya-zakupka-2020-11-05")
        var stockPage = StockPage()
        stockPage.expandGoodRow(BOOTS!!)
        vrt.track(
                "Stock Page Row",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
    }

    @Test(priority = 3, dataProvider = "browserParamsData")
    fun stockDescription(width: Int, height: Int, options: TestRunOptions) {
        Driver.get().manage().window().size = Dimension(width, height)
        StockPage.open("261-avtomaticheski-sozdannaya-zakupka-2020-11-05")
        var stockPage = StockPage()
        stockPage.openDescription()
        vrt.track(
                "Stock Page Description Tab",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
        stockPage.openAddCustomOrder()
        vrt.track(
                "Stock Page Custom Order Tab",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
        stockPage.openComments()
        vrt.track(
                "Stock Page Comments Tab",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
        stockPage.openDelivery()
        vrt.track(
                "Stock Page Delivery Tab",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
        stockPage.openPayment()
        vrt.track(
                "Stock Page Payment Tab",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
        stockPage.openAddCustomOrder()
        vrt.track(
                "Stock Page Custom Order",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
    }
}