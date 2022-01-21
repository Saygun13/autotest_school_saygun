package main

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import main.BaseClass

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


}