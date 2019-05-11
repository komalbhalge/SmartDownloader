package android.komal.com.mydownloaderlib.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ImageRepository {

    private val api : ApiService by lazy  {ServiceProvider.provideRetrofit().create(ApiService::class.java) }

    fun getProjectList(url: String): LiveData<Bitmap> {
        val data = MutableLiveData<Bitmap>()

        api!!.getImageData(url).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        // display the image data in a ImageView or save it
                        val bmp = BitmapFactory.decodeStream(response.body()!!.byteStream())
                        data.setValue(bmp)
                    } else {
                        data.setValue(null)
                    }
                } else {
                    data.setValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                data.value = null

            }

        })

        return data
    }

    companion object {
        private var projectRepository: ImageRepository? = null

        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        val instance: ImageRepository
            @Synchronized get() {
                if (projectRepository == null) {
                    if (projectRepository == null) {
                        projectRepository = ImageRepository()
                    }
                }
                return projectRepository as ImageRepository
            }
    }


    // …
}
