package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.databinding.FragmentQuestionBinding
import com.ddona.demorecycleview.db.DataBaseManager
import com.ddona.demorecycleview.model.Question
import com.ddona.demorecycleview.ui.adapter.QuestionAdapter

class QuestionFragment:Fragment(), QuestionAdapter.IQuestion {
    private val questions = mutableListOf<Question>()
    private lateinit var database:DataBaseManager
    private lateinit var binding:FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = DataBaseManager(activity!!)
        binding = FragmentQuestionBinding.inflate(
            inflater,container, false
        )
        initData()
        binding.rc.layoutManager = LinearLayoutManager(activity!!)
        binding.rc.adapter = QuestionAdapter(this)
        return binding.root
    }
    private fun initData(){
        questions.addAll(
            database.getFifteen()
        )
        questions.addAll(
            database.getFifteen()
        )
        questions.addAll(
            database.getFifteen()
        )
        questions.addAll(
            database.getFifteen()
        )
        questions.addAll(
            database.getFifteen()
        )
    }

    override fun getCount()= questions.size
    override fun getData(position: Int): Question {
        return questions[position]
    }
}