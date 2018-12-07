# GSlider
This is a slide show library written in **kotlin**.

Using this Library you can simply turn any ImageView into a Slide Show, it only supports links.

With a little help from [Glide](https://github.com/bumptech/glide) and [Anko](https://github.com/Kotlin/anko).


# Adding to your Project

Step 1 : Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

:small_orange_diamond: **Gradle:**

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
:small_blue_diamond: **maven:**

```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2 : Add the dependency

:small_orange_diamond: **Gradle:**

```
	dependencies {
	        implementation 'com.github.mojirzg:GSlider:0.1.0'
	}
```

:small_blue_diamond: **maven:**

```
	<dependency>
	    <groupId>com.github.mojirzg</groupId>
	    <artifactId>GSlider</artifactId>
	    <version>Tag</version>
	</dependency>
```

# Usage
Make an object from GSlide and pass the Context, ImageView and a list of image urls:

```
  val imageUrlList = arrayListOf<String>()
  imageUrlList.add("https://www.android.com/static/2016/img/share/andy-lg.png")
  imageUrlList.add("https://d3nmt5vlzunoa1.cloudfront.net/kotlin/files/2017/05/android_kotlin.png")
  imageUrlList.add("http://stocknews.com/wp-content/uploads/2017/07/android-googl.jpg")

  val gSlider = GSlider(this,imageView,imageUrlList)
```

Then just call the start function:

```
gSlider.start()
```

:warning: **Don't forget to call gSlider.stop() in your activity's onPause:**

```
    override fun onPause() {
      super.onPause()
      gSlider.stop()
    }
```

