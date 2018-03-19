package pl.dawidfiruzek.kursandroid.feature.commons

interface BaseContract {

    interface Presenter {
        fun initialize()
        fun clear()
    }
}