package tests

import constructor.classes.UserData
import constructor.classes.locatorsTypes
import locators.*
import main.GeneralScenariosForTests
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class TestOne : TestMethods() {

    @Test
    fun testOne() {

        //Соглашение на трек аналитики
        clickToElement(
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = PermissionDialogLocators().buttonAllow.iosAccessibilityId
        )

        //Пропуск онбординга
        try {
            clickToElement(
                androidLocatorType = locatorsTypes.androidXPath,
                androidLocator = OnbordingScreenLocators().skipButtonOnSplashScreen.androidXPath,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = OnbordingScreenLocators().skipButtonOnSplashScreen.iosAccessibilityId

            )
            println("Тест прошел")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден. Скипаем тест")
        }

        //Прогон основных методов авторизации
        GeneralScenariosForTests().basicAuth()

        //Отказ в доступе к геолокации
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = PermissionDialogLocators().buttonDeny.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = PermissionDialogLocators().buttonDeny.iosAccessibilityId
        )

        //Скип QSG
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = CityListScreenLocators().qsgOverlay.androidId,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = CityListScreenLocators().qsgOverlay.iosXPath
        )

        //Выбор первого города
        clickToElement(
            androidLocatorType = locatorsTypes.androidXPath,
            androidLocator = CityListScreenLocators().firstCityElement.androidXPath,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = CityListScreenLocators().firstCityElement.iosXPath
        )

        //Ожидание загрузки главного экрана
        elementIsDisplayed(
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = MainScreenLocators().searchBar.iosAccessibilityId
        )

        //Логаут
        GeneralScenariosForTests().logout()


        TimeUnit.SECONDS.sleep(5)

    }
}