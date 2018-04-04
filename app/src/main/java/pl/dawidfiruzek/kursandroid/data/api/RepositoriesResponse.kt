package pl.dawidfiruzek.kursandroid.data.api

data class RepositoriesResponse(
        val name: String,
        val description: String,
        private val owner: OwnerData
) {
    val imageUrl = owner.avatar_url
}