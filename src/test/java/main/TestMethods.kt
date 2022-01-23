package main

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import constructor.classes.locatorsTypes
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.Config
import utils.PlatformTouchAction
import java.time.Duration

open class TestMethods : BaseClass() {

    fun clickToElement(locatorType: String, locator: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            "id" -> element = driver.findElement(MobileBy.id(locator))
            "xpath" -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.click()
    }

    fun inputTextInField(locatorType: String, locator: String, inputText: String) {

        lateinit var element: MobileElement
        when (locatorType) {
            "id" -> element = driver.findElement(MobileBy.id(locator))
            "xpath" -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.sendKeys(inputText)
    }

    // Есть вопрос по поводу проверки доступности. Почему нельзя просто использовать isDisplayed,
    fun elementIsDisplayed(locatorType: String, locator: String) {

        lateinit var element: MobileElement
        when (locatorType) {
            "id" -> element = driver.findElement(MobileBy.id(locator))
            "xpath" -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.isDisplayed
    }

    fun checkAvailableElement (locatorType: String, locator: String) {
        var checkAvailableElement = false // создаем объект типа Boolean
        when (locatorType) {
        "id" -> checkAvailableElement = driver.findElement(MobileBy.id(locator)).isEnabled
        "AccessibilityId" -> checkAvailableElement = driver.findElement(MobileBy.AccessibilityId(locator)).isEnabled
        "xpath" -> checkAvailableElement = driver.findElement(MobileBy.xpath(locator)).isEnabled
    } // у поиска сразу происходит обращение к атрибуту и возвращает true или false
    AssertJUnit.assertTrue(checkAvailableElement) // проверка значение checkAvailableElement на true, возвращает true или false
}

    fun clearField(locatorType: String, locator: String) {

        lateinit var element: MobileElement
        when (locatorType) {
            "id" -> element = driver.findElement(MobileBy.id(locator))
            "xpath" -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.clear()
    }

    fun swipeOnScreen(
        startCordX: Int,
        startCordY: Int,
        moveCordX: Int,
        moveCordY: Int
    ) {
        PlatformTouchAction(driver)
            .longPress(PointOption.point(startCordX, startCordY))
            .moveTo(PointOption.point(moveCordX, moveCordY))
            .release()
            .perform()
    }

    fun tapByCoordinates(
        cordX: Int,
        cordY: Int,
    ) {
        PlatformTouchAction(driver)
            .tap(PointOption.point(cordX, cordY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
            .perform()
    }
}