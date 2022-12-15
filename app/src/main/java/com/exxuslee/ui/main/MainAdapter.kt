package com.exxuslee.ui.main

import android.content.res.TypedArray
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exxuslee.databinding.RecyclerFistBinding
import com.exxuslee.domain.model.Player

class MainAdapter(private val icons: TypedArray) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var selectedPosition: Int = -1
    private var players: List<Player> = listOf()
    var onPlayerClickListener: ((Int) -> Unit)? = null
    var onIconClickListener: ((Int) -> Unit)? = null

    inner class ViewHolder(val binding: RecyclerFistBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            RecyclerFistBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val strength = players[position].bonus + players[position].level
        val iconID = players[position].icon
        holder.binding.apply {
            icon.setImageDrawable(icons.getDrawable(iconID))
            name.text = players[position].name
            level.text = players[position].level.toString()
            bonus.text = players[position].bonus.toString()
            life.text = strength.toString()
            icon.setOnClickListener { onIconClickListener?.invoke(position) }
        }
        holder.itemView.apply {
            setBackgroundColor(if (selectedPosition == position) Color.LTGRAY else Color.TRANSPARENT)
            setOnClickListener {
                notifyItemChanged(selectedPosition)
                selectedPosition = holder.adapterPosition
                notifyItemChanged(position)
                onPlayerClickListener?.invoke(position)
            }
        }
    }

    override fun getItemCount() = players.size

    fun updateAdapter(listPlayers: List<Player>) {
        //listPlayers?.map { player -> players = players.plus(player) }
        players = listPlayers
        notifyDataSetChanged()
    }

    companion object {
        const val TAG = "player"
    }
}
