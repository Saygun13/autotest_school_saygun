package locators

import constructor.classes.LocatorsConstructor

class CityListScreenLocators {

    val qsgOverlay = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/viewFlipper",
        iosXPath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]"
    )

    val firstCityElement = LocatorsConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]",
        iosId = "9B000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]"
    )

}