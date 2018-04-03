package pl.dawidfiruzek.kursandroid.feature.repositories.ui

import android.os.Bundle
import android.os.Parcelable
import org.parceler.Parcels
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.utils.configuration.StringConstants.EXTRA_KEY_EXAMPLE
import timber.log.Timber
import javax.inject.Inject

class RepositoriesActivity : BaseActivity(), RepositoriesContract.View {

    @Inject
    lateinit var presenter: RepositoriesContract.Presenter

    override val layoutId: Int =
            R.layout.activity_repositories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
        val extra: Parcelable? = intent.getParcelableExtra(EXTRA_KEY_EXAMPLE)
        extra?.let {
            val value = Parcels.unwrap<Int>(it)
            Timber.d("Extra value passed to activity is $value")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}
