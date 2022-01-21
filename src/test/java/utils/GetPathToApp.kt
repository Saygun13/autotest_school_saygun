package utils

import java.io.File

class GetPathToApp {

    init {

        val matchingFileApk = APK_PATH.listFiles { _, name ->
            if (name.contains("sportmaster"))
                apkName = name
            name.startsWith("sportmaster")
        }
        val matchingFileApp = APP_PATH.listFiles { _, name ->
            if (name.contains("sportmaster"))
                appName = name
            name.startsWith("sportmaster")
        }
    }

    private var apkName: String? = null
    private var appName: String? = null

    val fullLocalAppLocalPathIOS = "/Users/$USER_NAME/Projects/apps/Sportmaster_ios/$appName"
    val fullAppLocalPathAndroid = "/Users/$USER_NAME/Projects/apps/Sportmaster_android/$apkName"
    val fullAppCiPathAndroid = ""
    val fullAppCiPathIOS = ""

    companion object {
        private val USER_NAME: String = System.getProperty("user.name")
        private val F = File("/Users/$USER_NAME/Library/Developer/Xcode/DerivedData/")
        private val APK_PATH = File("/Users/$USER_NAME/Projects/apps/Sportmaster_android/")
        private val APP_PATH = File("/Users/$USER_NAME/Projects/apps/Sportmaster_ios/")
    }
}

val appPath = GetPathToApp()
