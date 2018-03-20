package pl.dawidfiruzek.kursandroid

import timber.log.Timber

class KursApplication : BaseApplication() {

    override fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}