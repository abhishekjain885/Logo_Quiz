package com.example.quiz.presentation.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.Button

class GridSuggestAdapter(
    private var context: Context?,
    private var suggestSource: ArrayList<String>
) : BaseAdapter() {


    override fun getCount(): Int {
        return suggestSource.size
    }

    override fun getItem(position: Int): Any {
        return suggestSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val button: Button
        if (convertView == null) {
            if (suggestSource[position] == "null") {
                button = Button(context)
                button.layoutParams = AbsListView.LayoutParams(85, 85)
                button.setPadding(8, 8, 8, 8)
                button.setBackgroundColor(Color.WHITE)
            } else {
                button = Button(context)
                button.layoutParams = AbsListView.LayoutParams(85, 85)
                button.setPadding(8, 8, 8, 8)
                button.setBackgroundColor(Color.WHITE)
                button.setTextColor(Color.BLUE)
                button.text = suggestSource[position]

            }
        } else button = convertView as Button
        return button
    }


}