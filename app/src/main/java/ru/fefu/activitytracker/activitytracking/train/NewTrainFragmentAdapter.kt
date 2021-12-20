package ru.fefu.activitytracker.activitytracking.train

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R

class NewTrainFragmentAdapter (train_types: List<TrainTypeCard>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder> (){

    private val mutableCards = train_types.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.train_type_card_item, parent, false)
        return NewTrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewTrainViewHolder).bind(mutableCards[position])
        holder.itemView.isSelected = mutableCards[position].isSelected
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class NewTrainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val trainType: TextView = itemView.findViewById(R.id.train_name)

        fun bind(trainTypeCard: TrainTypeCard) {
            trainType.text = trainTypeCard.train_type
        }

        init {
            itemView.setOnClickListener {
                for (card in mutableCards) {
                    card.isSelected = false
                }
                mutableCards[adapterPosition].isSelected = true
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int =
        mutableCards.size
}