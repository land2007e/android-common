package com.ddona.demorecycleview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ddona.demorecycleview.databinding.ActivityAnimationBinding

class AnimationActivity :AppCompatActivity(), View.OnClickListener, Animation.AnimationListener {
    private lateinit var binding: ActivityAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animation)

        binding.btnTranslate.setOnClickListener(this)
        binding.btnRorate.setOnClickListener(this)
        binding.btnAlpha.setOnClickListener(this)
        binding.btnScale.setOnClickListener(this)
        binding.btnSet.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_translate->{
                //load animation tu xml len
                val ani = AnimationUtils.loadAnimation(this, R.anim.demo_translate)
                //bat su kien cua animation
                ani.setAnimationListener(this)
                //dua animation vao view va chay animation
                binding.iv.startAnimation(ani)
            }
            R.id.btn_rorate->{
                //load animation tu xml len
                val ani = AnimationUtils.loadAnimation(this, R.anim.demo_rotate)
                ani.setAnimationListener(this)
                //dua animation vao view va chay animation
                binding.iv.startAnimation(ani)
            }
            R.id.btn_alpha->{
                //load animation tu xml len
                val ani = AnimationUtils.loadAnimation(this, R.anim.demo_alpha)
                ani.setAnimationListener(this)
                //dua animation vao view va chay animation
                binding.iv.startAnimation(ani)
            }
            R.id.btn_scale->{
                //load animation tu xml len
                val ani = AnimationUtils.loadAnimation(this, R.anim.demo_scale)
                ani.setAnimationListener(this)
                //dua animation vao view va chay animation
                binding.iv.startAnimation(ani)
            }
            R.id.btn_set->{
                //load animation tu xml len
                val ani = AnimationUtils.loadAnimation(this, R.anim.demo_set)
                ani.setAnimationListener(this)
                //dua animation vao view va chay animation
                binding.iv.startAnimation(ani)
            }
        }
    }

    override fun onAnimationRepeat(ani: Animation) {
        Log.d("AnimationActivity", "onAnimationRepeat.......")
    }

    override fun onAnimationEnd(p0: Animation?) {
        Log.d("AnimationActivity", "onAnimationEnd.......")
    }

    override fun onAnimationStart(p0: Animation?) {
        Log.d("AnimationActivity", "onAnimationStart.......")
    }
}