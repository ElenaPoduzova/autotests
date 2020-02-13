package com.sp.frontend.uitest.testutils

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.MatchLevel
import com.applitools.eyes.selenium.Eyes
import com.applitools.eyes.selenium.StitchMode
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.DataProvider
import java.lang.reflect.Method
import java.net.MalformedURLException
import java.net.URL
import java.rmi.UnexpectedException

/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider in order to supply multiple browser combinations.
 *
 * @author Neil Manvar
 */
open class TestNGCrossBrowserBase {
    var username = "elena.poduzova@gmail.com"
    var authkey = "E0Sm1kDZowqZ0rfwuMtzBxNjKGRAzvfw1W4Jksa1062Hs110"
    var webDriver = ThreadLocal<WebDriver>()
    fun getWebDriver(): WebDriver {
        return webDriver.get()
    }

    private val sessionId = ThreadLocal<String>()
    fun getSessionId(): String {
        return sessionId.get()
    }

    private val myEyes = ThreadLocal<Eyes>()
    val eyes: Eyes
        get() = myEyes.get()

    /**
     * Constructs a new [RemoteWebDriver] instance which is configured to use the capabilities defined by the browser,
     * version and os parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the [//authentication] instance.
     *
     * @param browser Represents the browser to be used as part of the test run.
     * @param version Represents the version of the browser to be used as part of the test run.
     * @param os Represents the operating system to be used as part of the test run.
     * @param resolution Represents the operating system virtual resolution. Should always set to max available.
     * @param methodName Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
    @Throws(MalformedURLException::class, UnexpectedException::class)
    protected fun createDriver(browser: String?, version: String?, os: String?, resolution: String?, methodName: String?) {
        val capabilities = DesiredCapabilities()
        // set desired capabilities to launch appropriate browser on Sauce
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser)
        capabilities.setCapability(CapabilityType.VERSION, version)
        capabilities.setCapability(CapabilityType.PLATFORM, os)
        capabilities.setCapability("screenResolution", resolution)
        capabilities.setCapability("name", methodName)
        capabilities.setCapability("record_video", "true")
        // Launch remote browser and set it as the current thread
        webDriver.set(RemoteWebDriver(
                URL("http://$username:$authkey@hub.crossbrowsertesting.com:80/wd/hub"),
                capabilities))
        //webDriver.set(new ChromeDriver());
        myEyes.set(Eyes())
        eyes.apiKey = System.getenv("APPLITOOLS_KEY")
        eyes.hideScrollbars = true
        eyes.forceFullPageScreenshot = true
        eyes.stitchMode = StitchMode.CSS
        eyes.matchLevel = MatchLevel.LAYOUT2
        eyes.batch = batch
        eyes.baselineEnvName = "MyCrossBrowserTest"
        // set current sessionId
        val id = (getWebDriver() as RemoteWebDriver).sessionId.toString()
        sessionId.set(id)
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown(result: ITestResult?) {
        webDriver.get().quit()
    }

        /**
         * DataProvider that explicitly sets the browser combinations to be used.
         *
         * @param testMethod
         * @return Two dimensional array of objects with browser, version, and platform information
         */
//Comment out all but one for your initial baseline sample. After your baseline is created then uncomment out each browser/os combo to do cross browser testing.
        @DataProvider(name = "hardCodedBrowsers", parallel = true)
        fun cbtBrowserDataProvider(testMethod: Method?): Array<Array<Any>> {
            return arrayOf(arrayOf<Any>("Chrome", "60", "Windows 10", "2560x1920"), arrayOf<Any>("Internet Explorer", "9", "Windows 7", "1920x1080"), arrayOf<Any>("Safari", "9", "Mac OSX 10.11", "2560x1600"), arrayOf<Any>("Firefox", "54", "Mac OSX 10.12", "2560x1600"))
        }

        private var batch: BatchInfo? = null
        @BeforeClass
        fun batchInitialization() {
            batch = BatchInfo("TestNG CBT Applitools")
        }
}