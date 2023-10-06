package com.deltax72.informationboard.presentation.adapters.news

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.informationboard.R
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.utils.convertByteArrayToDrawable

class NewsAdapter(
    private val onRemoveNewsButtonClicked: (NewsModel) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    var newsList: MutableList<NewsModel> = emptyList<NewsModel>().toMutableList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class NewsViewHolder(
        itemView: View,
        private val onRemoveNewsButtonClicked: (NewsModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val username: TextView = itemView.findViewById(R.id.username)
        private val topic: TextView = itemView.findViewById(R.id.topic)
        private val message: TextView = itemView.findViewById(R.id.message)
        private val removeNews: ImageView = itemView.findViewById(R.id.removeNewsButton)

        fun bind(model: NewsModel, index: Int) {
            image.setImageDrawable(convertByteArrayToDrawable(
                model.image ?: byteArrayOf()
            ))

            username.text = model.username
            topic.text = model.topic
            message.text = model.message

            removeNews.setOnClickListener {
                onRemoveNewsButtonClicked(model)
                removeAt(index)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_news, parent, false),
            onRemoveNewsButtonClicked
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position], position)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun removeAt(position: Int) {
        newsList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, newsList.size)
    }
}
