package pl.dawidfiruzek.kursandroid.utils.api

import io.reactivex.Observable
import pl.dawidfiruzek.kursandroid.data.api.RepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposService {

    @GET("users/{user}/repos")
    fun repos(@Path("user") user: String): Observable<List<RepositoriesResponse>>
}