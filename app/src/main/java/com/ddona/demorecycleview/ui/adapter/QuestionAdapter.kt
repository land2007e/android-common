package com.ddona.demorecycleview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddona.demorecycleview.databinding.ItemQuestionBinding
import com.ddona.demorecycleview.model.Question

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {
    private val inter: IQuestion

    constructor(inter: IQuestion) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        return QuestionHolder(
            ItemQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = inter.getCount()

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.binding.data = inter.getData(position)
    }

    interface IQuestion {
        fun getCount(): Int
        fun getData(position: Int): Question
    }

    class QuestionHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)
}