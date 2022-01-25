package locators

import constructor.classes.LocatorsConstructor

class PermissionDialogLocators {

    val buttonDeny = LocatorsConstructor(
        androidId = "com.android.permissioncontroller:id/permission_deny_button",
        iosAccessibilityId = "Don’t Allow",
        iosXPath = "//XCUIElementTypeButton[@name=\"Don’t Allow\"]",
    )

    val buttonAllow = LocatorsConstructor(
        androidId = "",
        iosAccessibilityId = "Allow",
        iosXPath = "//XCUIElementTypeButton[@name=\"Allow\"]",
    )

}