package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.dawidfiruzek.kursandroid.data.RepositoryData
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.utils.api.ReposService
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import timber.log.Timber

class RepositoriesPresenter(
        private val view: RepositoriesContract.View,
        private val router: RepositoriesContract.Router,
        private val configuration: Configuration,
        private val reposService: ReposService,
        private val compositeDisposable: CompositeDisposable
) : RepositoriesContract.Presenter {

    override fun initialize() {
        compositeDisposable.add(
                reposService.repos(configuration.userLogin)
                        .flatMapIterable { it }
                        .map {
                            RepositoryData(
                                    it.name,
                                    it.description ?: "",
                                    it.imageUrl
                            )
                        }
                        .toList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { view.updateRepos(it) },
                                { Timber.e(it) }
                        )
        )
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun logoutClicked() {
        configuration.clear()
        router.navigateToLogin()
    }
}
