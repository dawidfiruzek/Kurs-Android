package pl.dawidfiruzek.kursandroid.utils.injection

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.data.RepositoryData
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.navigation.RepositoriesRouter
import pl.dawidfiruzek.kursandroid.feature.repositories.presentation.RepositoriesPresenter
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesAdapter
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration

@Module
class RepositoriesModule {

    @Provides
    fun layoutManager(activity: RepositoriesActivity): RecyclerView.LayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    @Provides
    fun data(): MutableList<RepositoryData> = ArrayList()

    @Provides
    fun adapter(data: MutableList<RepositoryData>): RepositoriesAdapter =
            RepositoriesAdapter(data)

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
