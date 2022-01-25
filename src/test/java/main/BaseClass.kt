package main

import io.appium.java_client.*
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import java.net.URL
import java.util.concurrent.TimeUnit
import utils.appPath
import utils.Config

open class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    @Parameters(
        value = ["paramPlatformVersion", "paramDeviceName", "paramPlatformName", "paramTimeToDelay"]
    )
    fun startDriver(
        paramPlatformVersion: String,
        paramDeviceName: String,
        paramPlatformName: String,
        paramTimeToDelay: Long
    ): AppiumDriver<MobileElement> {
        driver = Config().setupDriver(
            paramPlatformVersion,
            paramDeviceName,
            paramPlatformName,
            paramTimeToDelay
        )

        //TODO
        // проверка наличия онбординга+прохождение для главного экрана, минуя авторизацию, если онбординг найден
//        driver.closeApp()
//        driver.resetApp()

        return driver
    }

    @AfterSuite
    fun exitDriver() {
        Config().exitDriver(driver)
        println("Тест закончен")
    }


//    @BeforeClass
//    fun beforeClass() {
//        // заново инициализировать драйвер
//        // закрыть приложение
//    }
//
//    @AfterClass
//    fun afterClass() {
//
//    }
//
//    @BeforeMethod
//    fun beforeMethod() {
//    //запустить приложение
//        driver.launchApp()
//    }
//
//    @AfterMethod
//    fun afterMethod(){
//
//    }
//
}