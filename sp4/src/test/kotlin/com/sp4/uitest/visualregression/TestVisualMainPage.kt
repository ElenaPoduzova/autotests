package com.sp4.uitest.visualregression

import com.sp4.pages.LoginPage
import com.sp4.uitest.testutils.TestInitVrt
import com.uitestcore.driverutils.Driver
import io.visual_regression_tracker.sdk_java.TestRunOptions
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.annotations.Test

class TestVisualMainPage : TestInitVrt() {

    @Test(priority = 1, dataProvider = "browserParamsData")
    fun loginPageTest(width: Int, height: Int, options: TestRunOptions) {
        Driver.get().manage().window().size = Dimension(width, height)
        LoginPage.open()
        vrt.track(
                "Login Page",
                (Driver.get() as TakesScreenshot).getScreenshotAs(OutputType.BASE64),
                options
        )
    }
}