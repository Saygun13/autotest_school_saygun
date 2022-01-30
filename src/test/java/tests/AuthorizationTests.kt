package tests

import constructor.classes.locatorsTypes
import locators.*
import main.GeneralScenariosForTests
import main.TestMethods
import org.testng.AssertJUnit
import org.testng.annotations.Test


class AuthorizationTests: TestMethods() {


    //TODO
    // тут надо понаписать тестов для авторизации сервисов, с шторки добавления в избранное

    @Test
    fun authFromMainScenario() {

        if (GeneralScenariosForTests().checkAuth()) { GeneralScenariosForTests().logout()}


        // Клик на кнопку "Войти"
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = MainScreenLocators().buttonSignIn.androidId,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = MainScreenLocators().buttonSignIn.iosXPath
        )

        //Базовые методы авторизации
        GeneralScenariosForTests().basicAuth()

        //Проверка авторизованности пользователя
        AssertJUnit.assertTrue(GeneralScenariosForTests().checkAuth())

    }

    @Test
    fun authProfileMainScenario() {

        if (GeneralScenariosForTests().checkAuth()) { GeneralScenariosForTests().logout()}

        //Переход в профиль
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = TabbarLocators().buttonProfile.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = TabbarLocators().buttonProfile.iosAccessibilityId
        )

        //Клик на кнопку "Войти"
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = ProfileScreenLocators().buttonSignIn.androidId,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = ProfileScreenLocators().buttonSignIn.iosXPath
        )

        //Базовые методы авторизации
        GeneralScenariosForTests().basicAuth()

        //Проверка авторизованности пользователя
        AssertJUnit.assertTrue(GeneralScenariosForTests().checkAuth())

    }



}