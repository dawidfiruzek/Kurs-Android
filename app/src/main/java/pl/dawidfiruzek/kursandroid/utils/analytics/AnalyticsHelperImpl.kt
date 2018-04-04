package pl.dawidfiruzek.kursandroid.utils.analytics

import com.amplitude.api.Amplitude
import org.json.JSONObject

class AnalyticsHelperImpl : AnalyticsHelper {

    override fun logEvent(eventType: String, userProperties: List<Pair<String, Any>>?) {
        userProperties?.let {
            Amplitude.getInstance().logEvent(eventType, toJsonObject(it))
        } ?: Amplitude.getInstance().logEvent(eventType)
    }

    private fun toJsonObject(userProperties: List<Pair<String, Any>>): JSONObject =
            JSONObject(
                    userProperties.map {
                        it.first to it.second
                    }.toMap()
            )

    override fun setUserProperties(userProperties: List<Pair<String, Any>>) {
        Amplitude.getInstance().setUserProperties(toJsonObject(userProperties))
    }
}