package sopt.sopkathon.weing.data.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType
import sopt.sopkathon.weing.BuildConfig
import sopt.sopkathon.weing.data.remote.entity.RequestVoteService


object VoteApiFactory {

    private const val BASE_URL = "http://3.34.48.202:8080"

    val voteRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> voteCreate(): T = voteRetrofit.create<T>(T::class.java)
}

object ServicePool {

   val voteService = VoteApiFactory.voteCreate<RequestVoteService>()

}