package com.mayur.triviaapp.ui.questions

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mayur.triviaapp.R
import com.mayur.triviaapp.data.cache.UserData
import com.mayur.triviaapp.databinding.ItemHistoryBinding
import org.json.JSONObject
import java.util.*

class HistoryAdapter(private val list : List<UserData>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHistoryBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_history, parent, false)

        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val user = list.get(position)
        holder.bind(user)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class HistoryViewHolder (private val binding : ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(userData: UserData){

            binding.textDate.text = "GAME ${userData.id} : ${DateFormat.format("dd MMM yyyy hh:mm a", Date(userData.timestamp))}"
            binding.textName.text = "NAME : ${userData.name}"
            val json1 = JSONObject(userData.first_qa)
            binding?.qa1?.setText("${json1.getString("que")} \n\n ${json1.getString("ans")}")

            val json2 = JSONObject(userData.second_qa)
            binding?.qa2?.setText("${json2.getString("que")} \n\n ${json2.getString("ans")}")

        }
    }
}