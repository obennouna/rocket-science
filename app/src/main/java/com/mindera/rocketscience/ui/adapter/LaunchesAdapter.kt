package com.mindera.rocketscience.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mindera.rocketscience.R
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.mindera.rocketscience.utils.MethodUtils

class LaunchesAdapter : RecyclerView.Adapter<LaunchesAdapter.ViewHolder>() {
    private var launches: ArrayList<Launch> = ArrayList()
    private var rockets: ArrayList<Rocket> = ArrayList()
    private var mListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(launches[position])
    }

    fun onItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun setLaunches(newLaunches: List<Launch>) {
        launches.clear()
        launches.addAll(newLaunches)
    }

    fun setRockets(newRockets: List<Rocket>) {
        rockets.clear()
        rockets.addAll(newRockets)
    }

    inner class ViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding), View.OnClickListener {
        private lateinit var data: Launch
        fun bind(data: Launch) {
            this.data = data
            binding.findViewById<TextView>(R.id.launch_mission_title).text = data.name
            binding.findViewById<TextView>(R.id.launch_mission_date_content).text =
                MethodUtils.getDate(data.date_unix)
            if (rockets.isNotEmpty()) {
                val rocket = rockets.find { it.id == data.rocket }
                if (rocket != null) {
                    binding.findViewById<TextView>(R.id.launch_mission_rocket_content).text =
                        binding.context.getString(R.string.rocket_name_and_type, rocket.name, rocket.type)
                }
            }
            binding.findViewById<TextView>(R.id.launch_mission_days_label).text =
                MethodUtils.formatDateSinceOrFrom(binding.context, data.date_unix)
            binding.findViewById<TextView>(R.id.launch_mission_days_content).text =
                MethodUtils.formatDateDifference(binding.context, data.date_unix)
            if (data.links.patch.small != null) {
                binding.findViewById<ImageView>(R.id.launch_mission_image)
                    .load(data.links.patch.small)
            }
        }

        override fun onClick(v: View?) {
            mListener?.onItemClickListener(data)
        }
    }

    interface OnItemClickListener {
        fun onItemClickListener(data: Launch)
    }
}