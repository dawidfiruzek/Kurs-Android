package pl.dawidfiruzek.kursandroid.feature.utils.tools.parcel

import android.os.Parcelable
import org.parceler.Parcels

class ParcelableProviderImpl : ParcelableProvider {

    override fun from(from: Any): Parcelable =
            Parcels.wrap(from)
}
