package locators

import constructor.classes.LocatorsConstructor

class OnbordingScreenLocators {

    val skipButtonOnSplashScreen = LocatorsConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton",
        iosAccessibilityId = "closeButton",
        iosId = "0B000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"closeButton\"]"
    )

}