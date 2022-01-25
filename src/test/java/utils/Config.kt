package utils

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class Config {



    fun setupDriver( paramPlatformVersion: String, paramDeviceName: String, paramPlatformName: String, paramTimeToDelay: Long): AppiumDriver<MobileElement> {

        lateinit var driver: AppiumDriver<MobileElement>
        val URL = URL("http://0.0.0.0:4723/wd/hub")
        val caps = DesiredCapabilities()

        when (paramPlatformName) {
             "Android" -> {
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, paramPlatformName)
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, paramPlatformVersion)
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, paramDeviceName)
                caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.sportmaster.app.presentation.start.StartActivity")
                caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
                caps.setCapability(MobileCapabilityType.NO_RESET, "FALSE")
                caps.setCapability(MobileCapabilityType.APP, appPath.fullAppLocalPathAndroid)
//                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "")
//                caps.setCapability(MobileCapabilityType.UDID, "")

                 driver = AndroidDriver(URL, caps)
            }
            "iOS" -> {
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0")
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13")
                caps.setCapability(MobileCapabilityType.NO_RESET, "FALSE")
                caps.setCapability(MobileCapabilityType.APP, appPath.fullLocalAppLocalPathIOS)
//                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "")
//                caps.setCapability(MobileCapabilityType.UDID, "")

                driver = IOSDriver(URL, caps)
            }
        }
        driver.manage().timeouts().implicitlyWait(paramTimeToDelay, TimeUnit.SECONDS)

        return driver
        }

    fun exitDriver(driver: AppiumDriver<MobileElement>) {
        driver.quit()
    }

    }