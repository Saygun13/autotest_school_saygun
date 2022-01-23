package locators

import constructor.classes.LocatorsConstructor

class CityListScreenLocators {

    val qsgOverlay = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/viewFlipper"
    )

    val firstCityElement = LocatorsConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"
    )

}