package android.komal.com.mydownloaderlib.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.graphics.Bitmap
import android.komal.com.mydownloaderlib.network.ImageRepository

class ImageViewModel :ViewModel {

    private var data = MutableLiveData<Bitmap>()
    private lateinit var imageObservable: LiveData<Bitmap>

    constructor(url:String) {
        imageObservable = ImageRepository.instance.getProjectList(url)

    }
    fun ImageViewModel(application: Context) {

        // If any transformation is needed, this can be simply done by Transformations class ...
       }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    fun getProjectListObservable(): LiveData<Bitmap> {
        return imageObservable
    }
}