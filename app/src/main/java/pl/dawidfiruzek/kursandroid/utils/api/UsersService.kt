package pl.dawidfiruzek.kursandroid.utils.api

import io.reactivex.Observable
import pl.dawidfiruzek.kursandroid.data.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {

    @GET("users/{user}")
    fun user(@Path("user") user: String): Observable<UsersResponse>
}
