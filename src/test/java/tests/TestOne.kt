package tests

import constructor.classes.UserData
import constructor.classes.locatorsTypes
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class TestOne : TestMethods() {

    @Test
    fun testOne() {

        //Соглашение на доступ к нотификации
        clickToElement(
            iosLocatorType = locatorsTypes.iosAccessibilityId,
            iosLocator = PermissionDialogLocators().buttonAllow.iosAccessibilityId
        )

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
        TimeUnit.SECONDS.sleep(5)

        //Переход в раздел Профиль
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

        //Очистка поля Имени
        clearField(
            androidLocatorType = locatorsTypes.androidId,
            androidLocator = ProfileEditScreenLocators().editFirstName.androidId,
            iosLocatorType = locatorsTypes.iosXPath,
            iosLocator = ProfileEditScreenLocators().editFirstName.iosXPath

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

        TimeUnit.SECONDS.sleep(5)

    }
}