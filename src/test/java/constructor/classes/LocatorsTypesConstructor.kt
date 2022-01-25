package constructor.classes

data class LocatorsTypesConstructor constructor(
    val androidAccessibilityId: String = "accessibilityId",
    val androidId: String = "id",
    val androidXPath: String = "xpath",
    val iosAccessibilityId: String = "accessibilityId",
    val iosId: String = "id",
    val iosXPath: String = "xpath"
)

val locatorsTypes = LocatorsTypesConstructor()