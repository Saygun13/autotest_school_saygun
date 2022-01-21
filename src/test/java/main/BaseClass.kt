package main

import io.appium.java_client.*
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

class PlatformTouchAction(performsTouchActions: PerformsTouchActions) :
    TouchAction<PlatformTouchAction>(performsTouchActions)

class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>


    @BeforeSuite
    fun setupDriver() {

        val URL = URL("http://0.0.0.0:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_arm64-v8a")
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

    @Test
    fun testOne() {

        //Пропуск онбординга
        try {
            lateinit var buttonSkipOnboarding: MobileElement
            buttonSkipOnboarding =
                driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton"))
            buttonSkipOnboarding.click()
            println("Тест прошел")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден. Скипаем тест")
        }

        //Ввод телефонного номера
        lateinit var editPhoneNumber: MobileElement
        editPhoneNumber = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone"))
        editPhoneNumber.sendKeys("9999999998")

        //Запрос смс-кода
        lateinit var buttonSendCode: MobileElement
        buttonSendCode = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode"))
        buttonSendCode.click()

        //Ввод смс-кода
        lateinit var editSmsCode: MobileElement
        editSmsCode = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/pinCodeEditText"))
        editSmsCode.sendKeys("1111")

        //Отказ в доступе к геолокации
        lateinit var buttonSkipGeoPerm: MobileElement
        buttonSkipGeoPerm =
            driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_deny_button"))
        buttonSkipGeoPerm.click()

        //Скип QSG
        lateinit var buttonSkipGeoQSG: MobileElement
        buttonSkipGeoQSG = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/viewFlipper"))
        buttonSkipGeoQSG.click()

        //Выбор первого города
        lateinit var buttonCity: MobileElement
        buttonCity =
            driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
        buttonCity.click()

        //Ожидание загрузки главного экрана
        TimeUnit.SECONDS.sleep(5)

        //Переход в раздел Профиль
        lateinit var buttonTabbarProfile: MobileElement
        buttonTabbarProfile = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/profile_graph"))
        buttonTabbarProfile.click()

        //Переход в редактирование профиля
        lateinit var buttonEditProfile: MobileElement
        buttonEditProfile = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonEditProfile"))
        buttonEditProfile.click()

        //Скролл экрана
        TimeUnit.SECONDS.sleep(3)
        PlatformTouchAction(driver)
            .press(PointOption.point(590, 1200))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
            .moveTo(PointOption.point(590, 500))
            .release()
            .perform()

        //Логаут
        try {
            lateinit var buttonLogout: MobileElement
            buttonLogout = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonLogout"))
            buttonLogout.click()
            println("Логаут прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Кнопка логаута не найдена")
        }


        //Ожидание результата
        TimeUnit.SECONDS.sleep(5)

    }
}