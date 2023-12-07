package id.utdi.putridwioktaviani.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = //privat variabel untuk menyimpan URL
    "https://dekontaminasi.com"

private val retrofit = Retrofit.Builder()//builder retrofit
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AppApiService {
    @GET("api/id/covid19/hospitals") //membuat request Get dengan enpoint api/id/covid19/hospitals
    suspend fun getPhotos(): String
}

object AppApi { //deklarasi objek AppApi untuk retrofit
    val retrofitService: AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
}