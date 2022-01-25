package locators

import constructor.classes.LocatorsConstructor

class AuthScreenLocators {

    val editPhoneNumber = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone",
        iosId = "4B000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeOther[@name=\"editTextPhone\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"
    )

    val buttonSendCode = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode",
        iosAccessibilityId = "buttonGetCode",
        iosId = "3F000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"buttonGetCode\"]"
    )

    val editSmsCode = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/pinCodeEditText",
        iosAccessibilityId = "pinCodeEditText",
        iosId = "75000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeTextField[@name=\"pinCodeEditText\"]"
    )

}