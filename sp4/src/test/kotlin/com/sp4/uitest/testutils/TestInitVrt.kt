package com.sp4.uitest.testutils

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Logger
import io.visual_regression_tracker.sdk_java.TestRunOptions
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig
import org.openqa.selenium.Dimension
import org.testng.ITestResult
import org.testng.annotations.*

open class TestInitVrt {
    private var vtConfig = VisualRegressionTrackerConfig.builder()
            .apiUrl("http://localhost:4200")
            .apiKey("64R7Q2N44H4VR1JBERHKSY7W35GZ")
            .project("5f471c84-37db-41c5-86b5-6c179563d4ce")
            .branchName("master")
            .enableSoftAssert(true)
            .ciBuildId("1")
            .build()

    var vrt = VisualRegressionTracker(vtConfig)

    @BeforeClass
    @Throws(Exception::class)
    open fun beforeClass() {
        Driver.init()

        vrt.start()
    }

    @AfterTest
    fun afterClass() {
        Driver.get().quit()
        vrt.stop()
    }

    //Для запуска с разным разрешением и параметрами браузера
    @DataProvider(name = "browserParamsData")
    fun browserParamsData(): MutableIterator<Array<Any>> {
        val testData: ArrayList<Array<Any>> = arrayListOf()

        val opt1 = TestRunOptions.builder()
                .device("remote PC")
                .os("Windows")
                .browser("Chrome")
                .viewport("1360x1080")
                .build()

        val opt2 = TestRunOptions.builder()
                .device("remote PC")
                .os("Windows")
                .browser("Chrome")
                .viewport("768x1080")
                .build()

        val opt3 = TestRunOptions.builder()
                .device("remote PC")
                .os("Windows")
                .browser("Chrome")
                .viewport("320x1080")
                .build()

        val case1 = arrayOf(1360, 1080, opt1)
        val case2 = arrayOf(768, 1080, opt2)
        val case3 = arrayOf(320, 1080, opt3)

        testData.add(case1)
        testData.add(case2)
        testData.add(case3)

        return testData.iterator()
    }
}