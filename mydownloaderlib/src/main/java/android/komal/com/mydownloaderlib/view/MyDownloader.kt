package android.komal.com.mydownloaderlib.view

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.komal.com.mydownloaderlib.viewmodel.ImageViewModel
import android.widget.ImageView

class MyDownloader(private val mContext: Context, url: String) {
    private var imageView: ImageView? = null

    init {
        observeViewModel(ImageViewModel(url), mContext)
    }

    fun displayInto(imageView: ImageView) {
        this.imageView = imageView
    }

    private fun observeViewModel(viewModel: ImageViewModel, context: Context) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(context as LifecycleOwner, Observer { image ->
            if (image != null) {
                imageView!!.setImageBitmap(image)
                //…
                //projectAdapter.setProjectList(projects);
            }
        })
    }
}
