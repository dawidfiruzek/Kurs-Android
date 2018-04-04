package pl.dawidfiruzek.kursandroid.utils.configuration

import android.content.SharedPreferences
import com.orhanobut.hawk.Hawk

class ConfigurationImpl(
        private val sharedPreferences: SharedPreferences
) : Configuration {

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
            sharedPreferences.edit()
                    .putBoolean(PREFS_KEY_LOGGED_IN, true)
                    .apply()
        }

    override fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(PREFS_KEY_LOGGED_IN, false)
    }

    override fun clear() {
        Hawk.delete(PREFS_KEY_USER_LOGIN)
        sharedPreferences.edit()
                .putBoolean(PREFS_KEY_LOGGED_IN, false)
                .apply()
    }
}