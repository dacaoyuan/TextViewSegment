package com.ypk.textviewsegment

import android.app.Application
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration


/**
 * @Author:         YuanPeikai
 * @CreateDate:     2020/7/15 8:31
 * @Description:
 */
class InitApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        val imageLoader: ImageLoader = ImageLoader.getInstance()
        imageLoader.init(ImageLoaderConfiguration.createDefault(this))


    }


}