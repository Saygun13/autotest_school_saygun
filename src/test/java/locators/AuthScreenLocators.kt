package locators

import constructor.classes.LocatorsConstructor

class AuthScreenLocators {

    val closeAuthScreen = LocatorsConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton",
        iosAccessibilityId = "closeButton",
        iosId = "15000000-0000-0000-0840-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"closeButton\"]"
    )

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