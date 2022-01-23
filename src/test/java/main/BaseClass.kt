package main

import io.appium.java_client.*
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import java.net.URL
import java.util.concurrent.TimeUnit
import utils.appPath
import utils.Config

open class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun startDriver(): AppiumDriver<MobileElement>  {
        // Для запуска теста на iOS нужно набрать "iOS" в качестве входного параметра. 
        driver = Config().setupDriver("Android")
        return driver

    }

    @AfterSuite
    fun exitDriver() {
        Config().exitDriver(driver)
    }


}