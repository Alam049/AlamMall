package com.tecbabel.alammall.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tecbabel.alammall.ActivityByCategory
import com.tecbabel.alammall.ActivityDetail
import com.tecbabel.alammall.GlobalData
import com.tecbabel.alammall.R
import com.tecbabel.alammall.modal.Category
import com.tecbabel.alammall.modal.Orders
import kotlinx.android.synthetic.main.adapter_category.view.*
import kotlinx.android.synthetic.main.adapter_orders.view.*
import kotlinx.android.synthetic.main.adapter_product.view.*


class ItemOrder(var context: Context, var list: ArrayList<Orders>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class myCategory(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun category (name_products:String,id_users:Int,jumlahs:Int,cacatans:String){

            itemView.nama_product.text = name_products
            itemView.id_user.text = id_users.toString()
            itemView.jumlah.text = jumlahs.toString()
            itemView.cacatan.text = cacatans

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.adapter_orders,parent,false)

        return myCategory(view)
    }

    override fun getItemCount(): Int {


        return list.size

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as myCategory).category(list[position].nama_product,list[position].id_user,list[position].jumlah,list[position].cacatan)

    }
}