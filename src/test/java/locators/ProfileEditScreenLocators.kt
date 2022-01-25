package locators

import constructor.classes.LocatorsConstructor

class ProfileEditScreenLocators {

    val editFirstName = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextFirstName",
        iosId = "61000000-0000-0000-7AD8-000000000000",
        iosXPath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField"
    )
    val editLastName = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextLastName",
        iosId = "60000000-0000-0000-7AD8-000000000000",
        iosXPath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField"
    )

    val buttonLogout = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonLogout",
        iosAccessibilityId = "Выйти из профиля",
        iosId = "6B000000-0000-0000-7AD8-000000000000",
        iosXPath = "//XCUIElementTypeStaticText[@name=\"Выйти из профиля\"]"
    )

}