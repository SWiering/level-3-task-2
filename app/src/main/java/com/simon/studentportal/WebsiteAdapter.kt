package com.simon.studentportal

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_website.view.*

class WebsiteAdapter(private val reminders: List<Website>) : RecyclerView.Adapter<WebsiteAdapter.ViewHolder>() {

    lateinit var context: Context

    /**
     * Creates and returns a ViewHolder object, inflating the layout called item_reminder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_website, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return reminders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reminders[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(website: Website) {
            itemView.websiteButton.text = context.getString(R.string.website_result, website.name, website.url)
            itemView.setOnClickListener{openWebsite(website)}
        }
    }
    private fun openWebsite(website: Website) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website.url))
        context.startActivity(browserIntent)
    }
}