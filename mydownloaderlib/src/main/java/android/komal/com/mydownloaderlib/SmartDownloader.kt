package android.komal.com.mydownloaderlib

import android.content.Context
import android.komal.com.mydownloaderlib.view.MyDownloader

class SmartDownloader internal constructor(private val mContext: Context) {

    fun load(url: String): MyDownloader {
        return MyDownloader(mContext, url)
    }


}
