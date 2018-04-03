package pl.dawidfiruzek.kursandroid.utils.configuration

interface Configuration {
    val exampleExtra: Int
    fun isUserLoggedIn(): Boolean
}