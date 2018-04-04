package pl.dawidfiruzek.kursandroid.feature.repositories.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.data.RepositoryData

class RepositoriesAdapter(
        private val data: MutableList<RepositoryData>
) : RecyclerView.Adapter<RepositoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_repository, parent, false)
        return RepositoriesViewHolder(view)
    }

    override fun getItemCount(): Int =
            data.size

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.setData(data[position])
    }

    fun updateData(data: List<RepositoryData>) {
        this.data.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()

    }
}