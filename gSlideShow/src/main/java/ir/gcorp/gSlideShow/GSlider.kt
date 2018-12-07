package ir.gcorp.gSlideShow

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.jetbrains.anko.runOnUiThread
import java.util.*


class GSlider(private val context: Context, private val imageView: ImageView, private var gallery: ArrayList<String>, private val duration: Long = 2500) {


    private var position: Int = 0

    private val DURATION: Long = duration

    private var timer: Timer? = null


    private var animOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_out)
    private var animIn = AnimationUtils.loadAnimation(context, android.R.anim.fade_in)



    fun setAnimation(animOut : Animation , animIn : Animation){

        this.animOut = animOut
        this.animIn = animIn

    }

    fun reSetImages(gallery: ArrayList<String>){
        this.gallery = gallery
    }



    fun start() {

        if (timer != null) {
            timer?.cancel()
        }
        position = 0

        setPicture()

        startSlider()
    }

    fun stop() {
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }

    private fun startSlider() {
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {

            override fun run() {

                  context.runOnUiThread {
                    imageViewAnimation()

                }
            }

        }, 0, DURATION)
    }

   private fun imageViewAnimation() {

        animOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }
            override fun onAnimationStart(p0: Animation?) {
            }


            override fun onAnimationEnd(p0: Animation?) {

                setPicture()

                animIn.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(p0: Animation?) {
                    }
                    override fun onAnimationStart(p0: Animation?) {
                    }
                    override fun onAnimationEnd(p0: Animation?) {

                    }
            })

                imageView.startAnimation(animIn)
            }





        })
        imageView.startAnimation(animOut)

    }

    private fun setPicture() {
        Glide.with(context)
                .load(gallery[position])
                .into(imageView)

        position++
        if (position == gallery.size) {
            position = 0
        }
    }

}