package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest

class RepositoriesPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: RepositoriesContract.View

    @Mock
    private lateinit var router: RepositoriesContract.Router

    private lateinit var presenter: RepositoriesContract.Presenter

    override fun setup() {
        super.setup()
        presenter = RepositoriesPresenter(
                view,
                router
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router
        )
    }

    @Test
    fun `should do nothing when initialize is called`() {
        presenter.initialize()
    }

    @Test
    fun `should do nothing when clear is called`() {
        presenter.clear()
    }
}