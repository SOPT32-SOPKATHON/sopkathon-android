package sopt.sopkathon.weing.data.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import sopt.sopkathon.weing.data.remote.entity.request.RequestVoteService
import sopt.sopkathon.weing.presentation.kill.KillService

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
    val getKillService = VoteApiFactory.voteCreate<KillService>()
    val PreventionService = ApiFactory.create<ResponsePreventionService>()
    val ScoreService = ApiFactory.create<ResponseScoreService>()
    val rankingService = ApiFactory.create<RankingService>()
    val killService = KillApiFactory.create<KillService>()
}
