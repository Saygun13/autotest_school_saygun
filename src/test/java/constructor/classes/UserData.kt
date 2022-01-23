package constructor.classes

data class UserData constructor(
    val phoneNumber: String = "9999999998",
    val smsCode: String = "1111",
    val name: String = "",
    val surname: String = "",
    val patronymic: String = "",
    val email: String = "",
    val city: String = "",
    val street: String = "",
    val homeNumber: String = ""
)

val testUserForAuth = UserData(
    phoneNumber = "9999999998"
)
