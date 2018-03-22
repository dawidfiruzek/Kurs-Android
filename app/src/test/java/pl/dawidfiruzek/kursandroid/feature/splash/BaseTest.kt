package pl.dawidfiruzek.kursandroid.feature.splash

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.mockito.MockitoAnnotations

abstract class BaseTest {

    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    protected fun trampolineRxPlugin() {
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setSingleSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    open fun tearDown() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }
}