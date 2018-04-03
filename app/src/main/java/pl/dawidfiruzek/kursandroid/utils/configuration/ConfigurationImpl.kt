package pl.dawidfiruzek.kursandroid.utils.configuration

import com.orhanobut.hawk.Hawk

class ConfigurationImpl : Configuration {

    companion object {
        const val PREFS_KEY_LOGGED_IN = "IsUserLoggedIn"
        const val PREFS_KEY_USER_LOGIN = "UserLogin"
    }

    override val exampleExtra: Int =
            12

    override var userLogin: String
        get() = Hawk.get(PREFS_KEY_USER_LOGIN, "")
        set(value) {
            Hawk.put(PREFS_KEY_USER_LOGIN, value)
            Hawk.put(PREFS_KEY_LOGGED_IN, true)
        }

    override fun isUserLoggedIn(): Boolean {
        return Hawk.get<Boolean>(PREFS_KEY_LOGGED_IN, false)
    }
}