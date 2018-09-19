package com.test.kotlintest.ui.newslist.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.test.kotlintest.model.Article
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.test.kotlintest.R
import kotlinx.android.synthetic.main.article_list_item.view.*
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class ArticlesAdapter(private val context: Context, private val articles: List<Article>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private val clickSubject = PublishSubject.create<Article>()
    val clickEvent: Observable<Article> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.article_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = articles[position]
        Picasso.get().load(article.urlToImage).into(holder.articleImageView)
        holder.title.text = article.title
        holder.description.text = article.description

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var articleImageView: ImageView = view.articleImageView
        var title: TextView = view.articleTitleTextView
        var description: TextView = view.articleDescriptionTextView

        init {
            itemView.setOnClickListener {
                clickSubject.onNext(articles[layoutPosition])
            }
        }

    }
}
