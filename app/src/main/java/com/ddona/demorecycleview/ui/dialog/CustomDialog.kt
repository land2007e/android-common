package com.ddona.demorecycleview.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.CustomDialogBinding
import com.ddona.demorecycleview.db.DataBaseManager
import com.ddona.demorecycleview.model.Question
import com.ddona.demorecycleview.ui.adapter.QuestionAdapter

class CustomDialog : Dialog, QuestionAdapter.IQuestion {
    private lateinit var binding:CustomDialogBinding
    var functionOk : ((isOk:Boolean, name:String)->Unit)?=null

    private var questions = mutableListOf<Question>()
    constructor(context: Context):super(context){
        inits()
    }
    constructor(context: Context, themeResId: Int) : super(context, themeResId){
        inits()
    }

    private fun inits(){
        binding = CustomDialogBinding.inflate(
            LayoutInflater.from(context),
            null, false
        )
        //set giao dien cho dialog
        setContentView(binding.root)

        val data = DataBaseManager(context)
        questions.addAll(data.getFifteen())
        questions.addAll(data.getFifteen())
        questions.addAll(data.getFifteen())
        binding.rc.layoutManager = LinearLayoutManager(context)
        binding.rc.adapter = QuestionAdapter(this)

        binding.btnBack.setOnClickListener({
            dismiss()
        })
        binding.btnPlay.setOnClickListener({
            dismiss()
            functionOk?.invoke(true, "Test")
        })

//        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun getCount()=questions.size

    override fun getData(position: Int): Question {
       return questions[position]
    }
}