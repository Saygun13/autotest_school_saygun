package tests

import constructor.classes.LocatorsTypesConstructor
import constructor.classes.locatorsTypes
import utils.PlatformTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import locators.SplashScreenLocators
import main.TestMethods
import org.testng.annotations.Test
import java.time.Duration
import java.util.concurrent.TimeUnit



class TestOne: TestMethods() {

    @Test
    fun testOne() {

        //Пропуск онбординга
        try {
            clickToElement(
                locatorType = locatorsTypes.androidXPath,
                locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXPath
            )
            println("Тест прошел")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден. Скипаем тест")
        }

        //Ввод телефонного номера
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = "ru.sportmaster.app.handh.dev:id/editTextPhone",
            inputText = "9999999998"
        )

        //Запрос смс-кода
        clickToElement("id", "ru.sportmaster.app.handh.dev:id/buttonGetCode")

        //Ввод смс-кода
        inputTextInField("id", "ru.sportmaster.app.handh.dev:id/pinCodeEditText", "1111")

        //Отказ в доступе к геолокации
        clickToElement("id", "com.android.permissioncontroller:id/permission_deny_button")

        //Скип QSG
        clickToElement("id", "ru.sportmaster.app.handh.dev:id/viewFlipper")

        //Выбор первого города
        clickToElement(
            "xpath",
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"
        )

        //Ожидание загрузки главного экрана
        TimeUnit.SECONDS.sleep(5)

        //Переход в раздел Профиль
        clickToElement("id", "ru.sportmaster.app.handh.dev:id/profile_graph")

        //Переход в редактирование профиля
        clickToElement("id", "ru.sportmaster.app.handh.dev:id/buttonEditProfile")

        //Скролл экрана
        TimeUnit.SECONDS.sleep(3)
        swipeOnScreen(590,1200,590,500)

        //Логаут
        try {
            clickToElement("id", "ru.sportmaster.app.handh.dev:id/buttonLogout")
            println("Логаут прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Кнопка логаута не найдена")
        }

        //Ожидание результата
        TimeUnit.SECONDS.sleep(5)

    }
}