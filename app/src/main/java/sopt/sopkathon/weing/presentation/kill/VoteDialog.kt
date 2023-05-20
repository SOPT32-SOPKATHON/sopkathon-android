package sopt.sopkathon.weing.presentation.kill

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.DialogFragment
import retrofit2.Call
import retrofit2.Response
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.data.remote.api.ServicePool
import sopt.sopkathon.weing.data.remote.entity.RequestVoteDto
import sopt.sopkathon.weing.data.remote.entity.ResponseVoteDto
import sopt.sopkathon.weing.databinding.DialogVoteBinding
import sopt.sopkathon.weing.presentation.home.HomeActivity
import sopt.sopkathon.weing.presentation.ranking.RankingActivity
import sopt.sopkathon.weing.util.shortToastByInt


class VoteDialog : DialogFragment() {

    private var _binding: DialogVoteBinding? = null
    private val binding get() = _binding!!
    private var goodIconStatus: Boolean = false
    private var badIconStatus: Boolean = false
    private val voteService = ServicePool.voteService


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogVoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonStatus()
        clickGoodIcon()
        clickBadIcon()
        clickToHomeButton()
        clickToRankinButton()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(900, 1200)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickGoodIcon() {
        if (!badIconStatus) {
            binding.ivVoteGood.setOnClickListener {

                if (goodIconStatus) {
                    goodIconStatus = !goodIconStatus
                    binding.ivVoteGood.setImageResource(R.drawable.img_good)
                    binding.btnVoteToHome.isEnabled = false
                    binding.btnVoteToRanking.isEnabled = false
                    binding.btnVoteToHome.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_none_fill
                        )
                    binding.btnVoteToRanking.background =
                        getDrawable(requireContext(), R.drawable.rectangle_vote_radius_11_fill)

                } else {
                    goodIconStatus = !goodIconStatus
                    binding.ivVoteGood.setImageResource(R.drawable.img_good_click)
                    binding.btnVoteToHome.isEnabled = true
                    binding.btnVoteToRanking.isEnabled = true
                    binding.btnVoteToHome.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_none_fill_click
                        )
                    binding.btnVoteToRanking.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_fill_click
                        )

                    requestData("like")

                }


            }

        }


    }

    private fun clickBadIcon() {

        if (!goodIconStatus) {
            binding.ivVoteBad.setOnClickListener {

                if (badIconStatus) {
                    badIconStatus = !badIconStatus
                    binding.ivVoteBad.setImageResource(R.drawable.img_bad)
                    binding.btnVoteToHome.isEnabled = false
                    binding.btnVoteToRanking.isEnabled = false
                    binding.btnVoteToHome.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_none_fill
                        )
                    binding.btnVoteToRanking.background =
                        getDrawable(requireContext(), R.drawable.rectangle_vote_radius_11_fill)


                } else {
                    badIconStatus = !badIconStatus
                    binding.ivVoteBad.setImageResource(R.drawable.img_bad_click)
                    binding.btnVoteToHome.isEnabled = true
                    binding.btnVoteToRanking.isEnabled = true
                    binding.btnVoteToHome.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_none_fill_click
                        )
                    binding.btnVoteToRanking.background =
                        getDrawable(
                            requireContext(),
                            R.drawable.rectangle_vote_radius_11_fill_click
                        )

                    requestData("dislike")
                }

            }

        }


    }


    private fun clickToHomeButton() {
        binding.btnVoteToHome.setOnClickListener {
            dismiss()
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)

        }

    }


    private fun clickToRankinButton() {
        binding.btnVoteToRanking.setOnClickListener {
            dismiss()
            val intent = Intent(requireContext(), RankingActivity::class.java)
            startActivity(intent)

        }

    }

    private fun setButtonStatus() {
        binding.btnVoteToHome.isEnabled = false
        binding.btnVoteToRanking.isEnabled = false
    }


    private fun requestData(status: String) {

        voteService.vote(

            1,
            RequestVoteDto(
                status
            )
        ).enqueue(object : retrofit2.Callback<ResponseVoteDto> {
            override fun onResponse(
                call: Call<ResponseVoteDto>,
                response: Response<ResponseVoteDto>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.message?.let { Log.d("asdf", "$it") }

                } else {
                    response.body()?.message?.let { requireContext().shortToastByInt(it) }
                        ?: "서버통신 실패(40X)"
                }
            }

            override fun onFailure(call: Call<ResponseVoteDto>, t: Throwable) {

                t.message?.let { requireContext().shortToastByInt(it) } ?: "서버통신 실패(응답값 X)"
            }
        })


    }
}


