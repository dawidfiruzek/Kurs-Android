package pl.dawidfiruzek.kursandroid.utils.configuration

interface Configuration {
    val exampleExtra: Int
    var userLogin: String
    fun isUserLoggedIn(): Boolean
}