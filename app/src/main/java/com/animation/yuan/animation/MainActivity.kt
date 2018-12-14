package com.animation.yuan.animation

import android.animation.*
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.AnimatorSet
import android.transition.TransitionManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectAnimator = ObjectAnimator.ofFloat(tv_alpha, "scaleY", 1f, 3f, 1f)
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.RESTART
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.duration = 3000
        objectAnimator.start()

        //逐帧动画
        val frame0 = Keyframe.ofFloat(0f, 0f)
        val frame1 = Keyframe.ofFloat(0.1f, -20f)
        val frame2 = Keyframe.ofFloat(0.2f, 20f)
        val frame3 = Keyframe.ofFloat(0.3f, -20f)
        val frame4 = Keyframe.ofFloat(0.4f, 20f)
        val frame5 = Keyframe.ofFloat(0.5f, -20f)
        val frame6 = Keyframe.ofFloat(0.6f, 20f)
        val frame7 = Keyframe.ofFloat(0.7f, -20f)
        val frame8 = Keyframe.ofFloat(0.8f, 20f)
        val frame9 = Keyframe.ofFloat(0.9f, -20f)
        val frame10 = Keyframe.ofFloat(1f, 0f)
        frame2.setValue(0f)
        frame2.setInterpolator(BounceInterpolator())
        val frameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10)
        val animator = ObjectAnimator.ofPropertyValuesHolder(btn_press, frameHolder)
        animator.duration = 2000
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.start()

        //变大、变小
        val objectAnimator1 = ObjectAnimator.ofInt(myCicleView, "pointRadius", 30, 60, 50, 30)
        objectAnimator1.duration = 5000
        objectAnimator1.repeatCount = -1
        objectAnimator1.start()

//        val rotation = AnimationUtils.loadAnimation(this, R.anim.interpor_animator)
//        iv_scan.startAnimation(rotation)

        //平移
        ObjectAnimator.ofFloat(tv_x, "x", 20f, 10f, 50f, 10f, 100f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE

            start()
        }
        //同时移动
        val animator1 = ObjectAnimator.ofFloat(tv_x_together, "x", 20f, 10f, 50f, 10f, 100f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode=ObjectAnimator.REVERSE
        }
        val animator2 = ObjectAnimator.ofFloat(tv_x_together, "y", 20f, 10f, 50f, 10f, 100f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode=ObjectAnimator.REVERSE
        }
        val animatorSet = AnimatorSet()
        animatorSet.play(animator1).with(animator2)
        animatorSet.start()
        //一直旋转
        val hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.ratation_animator)
        iv_scan.startAnimation(hyperspaceJump)
        /*  val rotate = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.interpolator = LinearInterpolator() //是否匀速
            rotate.duration = 5000//设置动画持续周期
            rotate.repeatCount = -1//设置重复次数-1代表不停止
            rotate.start()
            iv_scan.animation = rotate*/

        //快变
        ObjectAnimator.ofInt(this, "backgroundColor", Color.RED, Color.BLACK, Color.BLUE).apply {
            target = tv_quick_color
            duration = 10000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }

        //渐变
        ObjectAnimator.ofInt(this, "backgroundColor", Color.WHITE, Color.GREEN).apply {
            setEvaluator(ArgbEvaluator())
            duration = 5000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
            addUpdateListener { animation ->
                run {
                    val value = animation.animatedValue as Int
                    tv_slow_color.setBackgroundColor(value)
                }
            }
            start()
        }

//        btn_press.setOnClickListener {
//            (AnimatorInflater.loadAnimator(this, R.anim.property_animator) as AnimatorSet).apply {
//                setTarget(iv_scan)
//                start()
//            }
//        }


//        btn_press.animate().apply {
//            interpolator = OvershootInterpolator()
//            duration = 5000
//            x(50f).y(100f).start()
//        }

//        iv_scan.animate().apply {
//            startDelay=2000
//            rotation(360f)
//            interpolator=LinearInterpolator()
//            duration=2000
//            start()
//        }


    }
}
