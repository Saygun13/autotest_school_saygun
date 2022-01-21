package constructor.classes

data class LocatorsTypesConstructor constructor(
    val id: String = "id",
    val androidXPath: String = "xpath"
)

val locatorsTypes = LocatorsTypesConstructor()