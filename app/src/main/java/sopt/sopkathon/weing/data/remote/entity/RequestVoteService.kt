package sopt.sopkathon.weing.data.remote.entity

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface RequestVoteService {
    @PATCH("/kill/{kill_id}/vote")
    fun vote(
        @Path("kill_id") killId: Int,
        @Body request: RequestVoteDto,
    ): Call<ResponseVoteDto>

}