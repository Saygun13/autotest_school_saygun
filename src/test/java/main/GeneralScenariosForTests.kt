package main

import constructor.classes.UserData
import constructor.classes.locatorsTypes
import locators.*
import org.apache.commons.lang3.BooleanUtils.xor
import org.testng.SkipException
import java.util.concurrent.TimeUnit

open class GeneralScenariosForTests : TestMethods() {

    //TODO
    // общие сценарии для тестов, которые используются в многих местах: например проход до главного экрана

    open fun firstLaunchScenario() {
        
        //TODO нужно сделать нормальный пропуск, чтобы корректно обрабатывались проваленные тесты в этом сценарии
        try {
            //
            clickToElement(
                androidLocatorType = locatorsTypes.androidXPath,
                androidLocator = OnbordingScreenLocators().skipButtonOnSplashScreen.androidXPath,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = OnbordingScreenLocators().skipButtonOnSplashScreen.iosAccessibilityId
            )


            //Пропуск авторизации
            clickToElement(
                androidLocatorType = locatorsTypes.androidXPath,
                androidLocator = AuthScreenLocators().closeAuthScreen.androidId,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = AuthScreenLocators().closeAuthScreen.iosAccessibilityId
            )

            //Отказ в доступе к геолокации
            clickToElement(
                androidLocatorType = locatorsTypes.androidId,
                androidLocator = PermissionDialogLocators().buttonDeny.androidId,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = PermissionDialogLocators().buttonDeny.iosAccessibilityId
            )

            //Скип QSG
            clickForSkipQSG()

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

            TimeUnit.SECONDS.sleep(1)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Онбординг не найден")
        }

    }

    open fun basicAuth() {

        //Ввод телефонного номера
        inputTextInField(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = AuthScreenLocators().editPhoneNumber.androidId,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = AuthScreenLocators().editPhoneNumber.iosXPath,
            inputText = UserData().phoneNumber
        )

        //Запрос смс-кода
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = AuthScreenLocators().buttonSendCode.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = AuthScreenLocators().buttonSendCode.iosAccessibilityId
        )

        //Ввод смс-кода
        inputTextInField(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = AuthScreenLocators().editSmsCode.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = AuthScreenLocators().editSmsCode.iosAccessibilityId,
            inputText = UserData().smsCode
        )


    }

    open fun logout() {

        //Переход в раздел профиль
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = TabbarLocators().buttonProfile.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = TabbarLocators().buttonProfile.iosAccessibilityId
        )

        //Переход в редактирование профиля
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = ProfileScreenLocators().buttonEditProfile.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = ProfileScreenLocators().buttonEditProfile.iosAccessibilityId
        )

        //Скролл экрана
        TimeUnit.SECONDS.sleep(3)
        swipeOnScreen(590, 1200, 590, 500)

        //Логаут
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = ProfileEditScreenLocators().buttonLogout.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = ProfileEditScreenLocators().buttonLogout.iosAccessibilityId
        )

        //Ожидание результата логаута. Наличие кнопки "Войти"
        try {
            elementIsDisplayed(
                androidLocatorType = locatorsTypes.androidId,
                androidLocator = ProfileScreenLocators().buttonSignIn.androidId,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = ProfileScreenLocators().buttonSignIn.iosAccessibilityId
            )
            println("Логаут прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Кнопка логаута не найдена")
        }

        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = TabbarLocators().buttonDashboard.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = TabbarLocators().buttonDashboard.iosAccessibilityId
        )

    }

    open fun checkAuth(): Boolean {

        var authed = false
        //Переход в раздел профиль
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = TabbarLocators().buttonProfile.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = TabbarLocators().buttonProfile.iosAccessibilityId
        )
        // проверка наличия кнопки "Войти"
        try {
            authed = elementIsDisplayed(
                androidLocatorType = locatorsTypes.androidId,
                androidLocator = ProfileScreenLocators().buttonSignIn.androidId,
                iosLocatorType = locatorsTypes.iosAccessibilityId,
                iosLocator = ProfileScreenLocators().buttonSignIn.iosAccessibilityId
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
        }

        //Переход на главный экран Главная
        clickToElement(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = TabbarLocators().buttonDashboard.androidId,
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = TabbarLocators().buttonDashboard.iosAccessibilityId
        )

        return !authed

    }


}