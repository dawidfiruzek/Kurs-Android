package pl.dawidfiruzek.kursandroid.utils.tools.parcel

import android.os.Parcelable

interface ParcelableProvider {
    fun from(from: Any): Parcelable
}
