package main

import constructor.classes.locatorsTypes
import io.appium.java_client.*
import locators.ProfileScreenLocators
import org.testng.annotations.*
import utils.Config
import java.util.concurrent.TimeUnit

open class BaseClass {

    companion object {
        lateinit var driver: AppiumDriver<MobileElement>
    }

    @BeforeSuite
    @Parameters(
        value = ["paramPlatformVersion", "paramDeviceName", "paramPlatformName", "paramTimeToDelay"]
    )
    fun startDriver( paramPlatformVersion: String, paramDeviceName: String, paramPlatformName: String, paramTimeToDelay: Long): AppiumDriver<MobileElement> {
        driver = Config().setupDriver(
            paramPlatformVersion,
            paramDeviceName,
            paramPlatformName,
            paramTimeToDelay
        )

        //TODO
        // проверка наличия онбординга+прохождение до главного экрана, минуя авторизацию, если онбординг найден
        GeneralScenariosForTests().firstLaunchScenario()

        driver.closeApp()
//        driver.resetApp()

        return driver
    }

    @AfterSuite
    fun exitDriver() {
        Config().exitDriver(driver)
        println("Тест закончен")
    }


    @BeforeClass
    fun beforeClass() {
        //TODO пока не понял для чего
        //заново инициализировать драйвер
        //закрыть приложение
        @Parameters(
            value = ["paramPlatformVersion", "paramDeviceName", "paramPlatformName", "paramTimeToDelay"]
        )
        fun startDriver( paramPlatformVersion: String, paramDeviceName: String, paramPlatformName: String, paramTimeToDelay: Long): AppiumDriver<MobileElement> {
            driver = Config().setupDriver(
                paramPlatformVersion,
                paramDeviceName,
                paramPlatformName,
                paramTimeToDelay
            )
            return driver
        }

        driver.closeApp()
    }
//
//    @AfterClass
//    fun afterClass() {
//        //TODO пока не понял для чего
//        //закрыть сессию драйвера
//        //driver.quit()
//    }
//
    @BeforeMethod
    fun beforeMethod() {
    //запустить приложение
        driver.launchApp()
        TimeUnit.SECONDS.sleep(5)
    }
//
//    @AfterMethod
//    fun afterMethod(){
//        driver.closeApp()
//    }

}