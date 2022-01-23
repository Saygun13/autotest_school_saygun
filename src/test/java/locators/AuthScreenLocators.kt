package locators

import constructor.classes.LocatorsConstructor

class AuthScreenLocators {

    val editPhoneNumber = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone"
    )

    val buttonSendCode = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode"
    )

    val editSmsCode = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/pinCodeEditText"
    )

}