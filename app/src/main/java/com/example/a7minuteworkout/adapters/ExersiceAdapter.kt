package com.example.a7minuteworkout.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.ExersiceModel
import com.example.a7minuteworkout.R
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class ExersiceAdapter(val items:ArrayList<ExersiceModel>,val context:Context) :
    RecyclerView.Adapter<ExersiceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_exercise_status,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model:ExersiceModel = items[position]
        holder.tvItem.text=model.getId().toString()

        if(model.getSelected()){
            holder.tvItem.background=ContextCompat.getDrawable(context,R.drawable.item_circular_thin_color_accent_border)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }
        else if(model.getCompleted()){
                holder.tvItem.background=ContextCompat.getDrawable(context,R.drawable.item_circular_color_accent_background)
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        }else{
            holder.tvItem.background=ContextCompat.getDrawable(context,R.drawable.item_circular_color_gray_background)
            holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvItem=view.tvItem

    }


}
