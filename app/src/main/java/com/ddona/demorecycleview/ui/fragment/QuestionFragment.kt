package com.ddona.demorecycleview.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.FragmentQuestionBinding
import com.ddona.demorecycleview.db.DataBaseManager
import com.ddona.demorecycleview.model.Question
import com.ddona.demorecycleview.ui.adapter.QuestionAdapter

class QuestionFragment : Fragment(), QuestionAdapter.IQuestion, View.OnClickListener {
    private val questions = mutableListOf<Question>()
    private lateinit var database: DataBaseManager
    private lateinit var binding: FragmentQuestionBinding
    private val musicIds = mutableListOf<Int>()
    private var currentIndex = -1
    private var media:MediaPlayer?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = DataBaseManager(activity!!)
        binding = FragmentQuestionBinding.inflate(
            inflater, container, false
        )
        initData()
        binding.rc.layoutManager = LinearLayoutManager(activity!!)
        binding.rc.adapter = QuestionAdapter(this)

        binding.btnPlay.setOnClickListener(this)

        musicIds.add(R.raw.background_music)
        musicIds.add(R.raw.background_music_b)
        musicIds.add(R.raw.background_music_c)
        musicIds.add(R.raw.ans_a)
        musicIds.add(R.raw.ans_c2)
        return binding.root
    }

    private fun initData() {
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

    override fun getCount() = questions.size
    override fun getData(position: Int): Question {
        return questions[position]
    }

    override fun onClick(v: View) {
        media?.release()
        currentIndex = (currentIndex + 1) % musicIds.size
        media = MediaPlayer.create(
            context,
            musicIds[currentIndex]
        )
        //mo nhac
        media?.start()
    }

    override fun onPause() {
        media?.pause()
        super.onPause()
    }


}