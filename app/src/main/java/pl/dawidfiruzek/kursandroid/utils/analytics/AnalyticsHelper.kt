package pl.dawidfiruzek.kursandroid.utils.analytics

interface AnalyticsHelper {
    fun logEvent(eventType: String, userProperties: List<Pair<String, Any>>? = null)
    fun setUserProperties(userProperties: List<Pair<String, Any>>)
}