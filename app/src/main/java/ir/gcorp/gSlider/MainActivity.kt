package ir.gcorp.gSlider

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.gcorp.gSlideShow.GSlider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var gSlider : GSlider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageUrlList = arrayListOf<String>()
        imageUrlList.add("https://www.android.com/static/2016/img/share/andy-lg.png")
        imageUrlList.add("https://d3nmt5vlzunoa1.cloudfront.net/kotlin/files/2017/05/android_kotlin.png")
        imageUrlList.add("http://stocknews.com/wp-content/uploads/2017/07/android-googl.jpg")



        gSlider = GSlider(this,imageView,imageUrlList)




        start.setOnClickListener{
            gSlider.start()
        }

        stop.setOnClickListener{
            gSlider.stop()
        }
    }


    override fun onPause() {
        super.onPause()
        gSlider.stop()
    }
}
