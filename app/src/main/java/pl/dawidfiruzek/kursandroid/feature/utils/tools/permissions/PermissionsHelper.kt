package pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions

import io.reactivex.Observable

interface PermissionsHelper {
    fun request(vararg permissions: String): Observable<Boolean>
}