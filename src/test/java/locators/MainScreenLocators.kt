package locators

import constructor.classes.LocatorsConstructor

class MainScreenLocators {

    val searchBar = LocatorsConstructor(
        androidAccessibilityId = "",
        androidId = "ru.sportmaster.app.handh.dev:id/editText",
        androidXPath = "",
        iosAccessibilityId = "Поиск",
        iosId = "50000000-0000-0000-B830-010000000000",
        iosXPath = "//XCUIElementTypeSearchField[@name=\"Поиск\"]"
    )

    val authBanner = LocatorsConstructor(
        androidAccessibilityId = "",
        androidId = "",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ViewFlipper/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup",
        iosAccessibilityId = "",
        iosId = "2B000000-0000-0000-B830-010000000000",
        iosXPath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther"
    )

    val buttonSignIn = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonAuth",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ViewFlipper/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.Button",
        iosId = "37000000-0000-0000-243E-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"Войти\"]"
    )
}