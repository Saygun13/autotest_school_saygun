package locators

import constructor.classes.LocatorsConstructor

class ProfileScreenLocators {

    val buttonSignIn = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonSignIn",
        iosAccessibilityId = "buttonSignIn",
        iosId = "29000000-0000-0000-7AD8-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"buttonSignIn\"]"
    )

    val buttonEditProfile = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonEditProfile",
        iosAccessibilityId = "edit",
        iosId = "5B010000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"edit\"]"
    )

}