package pl.dawidfiruzek.kursandroid.feature.repositories.ui

import android.os.Bundle
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import javax.inject.Inject

class RepositoriesActivity : BaseActivity(), RepositoriesContract.View {

    @Inject
    lateinit var presenter: RepositoriesContract.Presenter

    override val layoutId: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}
