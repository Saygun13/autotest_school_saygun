package main

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.Config
import utils.PlatformTouchAction
import java.time.Duration

open class TestMethods : BaseClass() {

    fun clickToElement(androidLocatorType: String = "", androidLocator: String = "", iosLocatorType: String = "", iosLocator: String = "") {
        lateinit var element: MobileElement
        if ((driver.platformName == "Android") && (androidLocator == "")) { return }
        if ((driver.platformName == "iOS") && (iosLocator == "")) { return }

        when (driver.platformName){
            "Android" -> {
                when (androidLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(androidLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(androidLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(androidLocator))

                }
            }
            "iOS" ->
                when (iosLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(iosLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(iosLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(iosLocator))
                }
        }

        element.click()
    }

    fun inputTextInField(androidLocatorType: String = "", androidLocator: String = "", iosLocatorType: String = "", iosLocator: String = "", inputText: String) {
        lateinit var element: MobileElement
        if ((driver.platformName == "Android") && (androidLocator == "")) { return }
        if ((driver.platformName == "iOS") && (iosLocator == "")) { return }
        when (driver.platformName){
            "Android" -> {
                when (androidLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(androidLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(androidLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(androidLocator))

                }
            }
            "iOS" ->
                when (iosLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(iosLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(iosLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(iosLocator))
                }
        }
        element.sendKeys(inputText)
    }

    // Есть вопрос по поводу проверки доступности. Почему нельзя просто использовать isDisplayed,
    fun elementIsDisplayed(androidLocatorType: String = "", androidLocator: String = "", iosLocatorType: String = "", iosLocator: String = "") {
        lateinit var element: MobileElement
        if ((driver.platformName == "Android") && (androidLocatorType == "")) { return }
        if ((driver.platformName == "iOS") && (iosLocatorType == "")) { return }
        when (driver.platformName){
            "Android" -> {
                when (androidLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(androidLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(androidLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(androidLocator))

                }
            }
            "iOS" ->
                when (iosLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(iosLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(iosLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(iosLocator))
                }
        }
        element.isDisplayed
    }

    fun checkAvailableElement (androidLocatorType: String = "", androidLocator: String = "", iosLocatorType: String = "", iosLocator: String = "") {
        var checkAvailableElement = false // создаем объект типа Boolean
        if ((driver.platformName == "Android") && (androidLocator == "")) { return }
        if ((driver.platformName == "iOS") && (iosLocator == "")) { return }

        when (driver.platformName){
            "Android" -> {
                when (androidLocatorType) {
                    "id" -> checkAvailableElement = driver.findElement(MobileBy.id(androidLocator)).isEnabled
                    "AccessibilityId" -> checkAvailableElement = driver.findElement(MobileBy.AccessibilityId(androidLocator)).isEnabled
                    "xpath" -> checkAvailableElement = driver.findElement(MobileBy.xpath(androidLocator)).isEnabled
                }
            }
            "Ios" ->
                when (iosLocatorType) {
                    "id" -> checkAvailableElement = driver.findElement(MobileBy.id(androidLocator)).isEnabled
                    "AccessibilityId" -> checkAvailableElement = driver.findElement(MobileBy.AccessibilityId(androidLocator)).isEnabled
                    "xpath" -> checkAvailableElement = driver.findElement(MobileBy.xpath(androidLocator)).isEnabled
                }
        }
        AssertJUnit.assertTrue(checkAvailableElement)
}

    fun clearField(androidLocatorType: String = "", androidLocator: String = "", iosLocatorType: String = "", iosLocator: String = "") {
        lateinit var element: MobileElement
        if ((driver.platformName == "Android") && (androidLocator == "")) { return }
        if ((driver.platformName == "iOS") && (iosLocator == "")) { return }
        when (driver.platformName){
            "Android" -> {
                when (androidLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(androidLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(androidLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(androidLocator))

                }
            }
            "iOS" ->
                when (iosLocatorType) {
                    "id" -> element = driver.findElement(MobileBy.id(iosLocator))
                    "xpath" -> element = driver.findElement(MobileBy.xpath(iosLocator))
                    "accessibilityId" -> element = driver.findElement(MobileBy.AccessibilityId(iosLocator))
                }
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