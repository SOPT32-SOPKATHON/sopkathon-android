package sopt.sopkathon.weing.data.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import sopt.sopkathon.weing.presentation.kill.KillService

object KillApiFactory {
    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("http://3.34.48.202:8080")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}
object ServicePool {
    val getKillService = KillApiFactory.create<KillService>()
}
