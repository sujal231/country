package com.example.country

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.country.databinding.ItemcountryBinding
import kotlinx.coroutines.InternalCoroutinesApi


class countryabapter() : RecyclerView.Adapter<countryabapter.countryHolder>() {

    lateinit var context: Context
    lateinit var countryList: List<Countrymodel>

    class countryHolder(itemView: ItemcountryBinding) : ViewHolder(itemView.root) {

        var binding = itemView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryHolder {

        context = parent.context
        var binding = ItemcountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return countryHolder(binding)
    }


    override fun getItemCount(): Int {
        return countryList.size
    }


    @OptIn(InternalCoroutinesApi::class)
    override fun onBindViewHolder(holder: countryHolder, position: Int) {
        holder.binding.apply {
            countryList.get(position).apply {
                Glide.with(context).load(countryList.get(position).flags?.png).into(imgflg)
                txtcountryname.text = name
                txtcapitalname.text = capital
                txtalpha3Code.text = alpha3Code

            }
        }


    }


    fun setcountrylist(countryList: List<Countrymodel>) {
        this.countryList = countryList
    }


}