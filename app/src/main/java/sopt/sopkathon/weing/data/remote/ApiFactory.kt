package sopt.sopkathon.weing.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import sopt.sopkathon.weing.data.remote.api.RankingService
import sopt.sopkathon.weing.data.remote.entity.ResponsePreventionService
import sopt.sopkathon.weing.data.remote.entity.ResponseScoreService

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                },
            ).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://3.34.48.202:8080/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val PreventionService = ApiFactory.create<ResponsePreventionService>()
    val ScoreService = ApiFactory.create<ResponseScoreService>()
    val rankingService = ApiFactory.create<RankingService>()
}
