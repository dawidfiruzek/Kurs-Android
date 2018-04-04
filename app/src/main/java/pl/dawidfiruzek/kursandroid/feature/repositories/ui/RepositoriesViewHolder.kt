package pl.dawidfiruzek.kursandroid.feature.repositories.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.data.RepositoryData

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.repository_image_view)
    lateinit var repositoryImageView: ImageView

    @BindView(R.id.repository_title)
    lateinit var titleTextView: TextView

    @BindView(R.id.repository_subtitle)
    lateinit var subtitleTextView: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(repositoryData: RepositoryData) = with(repositoryData) {
//        repositoryImageView = ??
        titleTextView.text = imageUrl
        subtitleTextView.text = subtitle
    }
}