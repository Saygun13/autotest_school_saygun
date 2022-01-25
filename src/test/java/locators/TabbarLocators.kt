package locators

import constructor.classes.LocatorsConstructor

class TabbarLocators {

    val buttonDashboard = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/dashboard_graph",
        iosAccessibilityId = "dashboard_graph",
        iosId = "D6000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"dashboard_graph\"]"
    )

    val buttonCatalog = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/catalog_graph",
        iosAccessibilityId = "catalog_graph",
        iosId = "D7000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"catalog_graph\"]"
    )

    val buttonServices = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/services_graph",
        iosAccessibilityId = "services_graph",
        iosId = "D8000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"services_graph\"]"
    )

    val buttonCart = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/ordering_graph",
        iosAccessibilityId = "ordering_graph",
        iosId = "D9000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"ordering_graph\"]"
    )

    val buttonProfile = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/profile_graph",
        iosAccessibilityId = "profile_graph",
        iosId = "DA000000-0000-0000-26D6-000000000000",
        iosXPath = "//XCUIElementTypeButton[@name=\"profile_graph\"]"
    )


}