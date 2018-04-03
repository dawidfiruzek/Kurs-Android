package pl.dawidfiruzek.kursandroid.feature.utils.tools.parcel

import android.os.Parcelable

interface ParcelableProvider {
    fun from(from: Any): Parcelable
}
