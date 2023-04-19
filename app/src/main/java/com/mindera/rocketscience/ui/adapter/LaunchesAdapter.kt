package com.mindera.rocketscience.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindera.rocketscience.R
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.utils.MethodUtils

class LaunchesAdapter : RecyclerView.Adapter<LaunchesAdapter.ViewHolder>() {
    private var launchs: ArrayList<Launch> = ArrayList()
    private var mListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return launchs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(launchs[position])
    }

    fun onItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun setData(newCategories: List<Launch>) {
        launchs.clear()
        launchs.addAll(newCategories)
    }

    inner class ViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding), View.OnClickListener {
        private lateinit var data: Launch
        fun bind(data: Launch) {
            this.data = data
            binding.findViewById<TextView>(R.id.launch_mission_title).text = data.name
            binding.findViewById<TextView>(R.id.launch_mission_date_content).text = MethodUtils.getDate(data.date_unix)
            binding.findViewById<TextView>(R.id.launch_mission_rocket_content).text = data.rocket
            binding.findViewById<TextView>(R.id.launch_mission_days_content).text = MethodUtils.formatDateDifference(binding.context, data.date_unix)
        }

        override fun onClick(v: View?) {
            mListener?.onItemClickListener(data)
        }
    }

    interface OnItemClickListener {
        fun onItemClickListener(data: Launch)
    }
}