package pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions

import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity

class PermissionsHelperImpl(
        private val activity: BaseActivity
) : PermissionsHelper {

    override fun request(vararg permissions: String): Observable<Boolean> =
            RxPermissions(activity).request(*permissions)
}