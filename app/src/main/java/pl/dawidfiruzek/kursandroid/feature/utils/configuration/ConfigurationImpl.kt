package pl.dawidfiruzek.kursandroid.feature.utils.configuration

import com.orhanobut.hawk.Hawk

class ConfigurationImpl : Configuration {

    companion object {
        const val PREFS_KEY_LOGGED_IN = "IsUserLoggedIn"
    }

    override val exampleExtra: Int =
            12

    override fun isUserLoggedIn(): Boolean {
        return true
        return Hawk.get<Boolean>(PREFS_KEY_LOGGED_IN, false)
    }
}