package tests

import constructor.classes.LocatorsTypesConstructor
import constructor.classes.UserData
import constructor.classes.locatorsTypes
import utils.PlatformTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.time.Duration
import java.util.concurrent.TimeUnit


class TestOne : TestMethods() {

    @Test
    fun testOne() {

        //Пропуск онбординга
        try {
            clickToElement(
                locatorType = locatorsTypes.androidXPath,
                locator = SplashScreenLocators().skipButtonOnSplashScreen.androidXPath
            )
            println("Тест прошел")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден. Скипаем тест")
        }

        //Ввод телефонного номера
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = AuthScreenLocators().editPhoneNumber.androidId,
            inputText = UserData().phoneNumber
        )

        //Запрос смс-кода
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = AuthScreenLocators().buttonSendCode.androidId
        )

        //Ввод смс-кода
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = AuthScreenLocators().editSmsCode.androidId,
            inputText = UserData().smsCode
        )

        //Отказ в доступе к геолокации
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = PermissionDialogLocators().buttonDeny.androidId,
        )

        //Скип QSG
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = CityListScreenLocators().qsgOverlay.androidId,
        )

        //Выбор первого города
        clickToElement(
            locatorType = locatorsTypes.androidXPath,
            locator = CityListScreenLocators().firstCityElement.androidXPath,
        )

        //Ожидание загрузки главного экрана
        TimeUnit.SECONDS.sleep(5)

        //Переход в раздел Профиль
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = TabbarLocators().buttonProfile.androidId,
        )

        //Переход в редактирование профиля
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = ProfileScreenLocators().buttonEditProfile.androidId,
        )

        //Очистка поля Имени
        clearField(
            locatorType = locatorsTypes.id,
            locator = ProfileEditScreenLocators().editFirstName.androidId
        )

        //Скролл экрана
        TimeUnit.SECONDS.sleep(3)
        swipeOnScreen(590, 1200, 590, 500)

        //Логаут
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = ProfileEditScreenLocators().buttonLogout.androidId,
        )


        //Ожидание результата логаута. Наличие кнопки "Войти"
        try {
            elementIsDisplayed(
                locatorType = locatorsTypes.id,
                locator = ProfileScreenLocators().buttonSignIn.androidId
            )
            println("Логаут прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Кнопка логаута не найдена")
        }

        TimeUnit.SECONDS.sleep(5)

    }
}