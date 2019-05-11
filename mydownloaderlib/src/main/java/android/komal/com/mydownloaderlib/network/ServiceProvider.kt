package android.komal.com.mydownloaderlib.network

import retrofit2.Retrofit

object ServiceProvider {
     fun provideRetrofit(): Retrofit {
        //retrofit2 must have base Url but you can put any url here
        return Retrofit.Builder()
                .baseUrl("https://google.com")
                .build()


    }
}