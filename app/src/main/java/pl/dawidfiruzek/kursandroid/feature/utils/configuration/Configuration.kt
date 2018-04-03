package pl.dawidfiruzek.kursandroid.feature.utils.configuration

interface Configuration {
    val exampleExtra: Int
    fun isUserLoggedIn(): Boolean
}