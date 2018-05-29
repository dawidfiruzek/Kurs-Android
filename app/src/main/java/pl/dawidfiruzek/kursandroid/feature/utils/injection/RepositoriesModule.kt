package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.navigation.RepositoriesRouter
import pl.dawidfiruzek.kursandroid.feature.repositories.presentation.RepositoriesPresenter
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity

@Module
class RepositoriesModule {

    @Provides
    fun router(
            activity: RepositoriesActivity
    ): RepositoriesContract.Router =
            RepositoriesRouter(activity)

    @Provides
    fun presenter(
            activity: RepositoriesActivity,
            router: RepositoriesContract.Router
    ): RepositoriesContract.Presenter =
            RepositoriesPresenter(
                    activity,
                    router
            )
}