package android.komal.com.mydownloaderlib.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET()
    fun getImageData(@Url url: String): Call<ResponseBody>
}