package pl.dawidfiruzek.kursandroid.feature.repositories.navigation

import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest

class RepositoriesRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: RepositoriesActivity

    private lateinit var router: RepositoriesContract.Router

    override fun setup() {
        super.setup()
        router = RepositoriesRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
    }
}
