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

open class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver() {

        val URL = URL("http://0.0.0.0:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a API 30")
        caps.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "ru.sportmaster.app.presentation.start.StartActivity"
        )
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
        caps.setCapability(MobileCapabilityType.NO_RESET, "FALSE")
        caps.setCapability(MobileCapabilityType.APP, "/Users/say_gun/Projects/sportmaster.apk")
//        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "")
//        caps.setCapability(MobileCapabilityType.UDID, "")

        driver = AndroidDriver(URL, caps)

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)

    }

    @AfterSuite
    fun exitDriver() {
        driver.quit()
    }


}