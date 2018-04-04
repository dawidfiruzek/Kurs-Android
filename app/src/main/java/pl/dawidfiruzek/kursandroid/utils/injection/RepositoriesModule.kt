package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.navigation.RepositoriesRouter
import pl.dawidfiruzek.kursandroid.feature.repositories.presentation.RepositoriesPresenter
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration

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
            router: RepositoriesContract.Router,
            configuration: Configuration
    ): RepositoriesContract.Presenter =
            RepositoriesPresenter(
                    activity,
                    router,
                    configuration
            )
}
