package sopt.sopkathon.weing.presentation.kill

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.databinding.DialogVoteBinding
import sopt.sopkathon.weing.presentation.home.HomeActivity
import sopt.sopkathon.weing.presentation.ranking.RankingActivity


class VoteDialog : DialogFragment() {

    private var _binding: DialogVoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogVoteBinding.inflate(inflater, container, false)
        val view = binding.root


        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        clickGoodIcon()
        clickBadIcon()
        clickToHomeButton()
        clickToRankinButton()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickGoodIcon() {
        binding.ivVoteGood.setOnClickListener {
            binding.ivVoteGood.setImageResource(R.drawable.img_good_click)
            binding.btnVoteToHome.isEnabled
            binding.btnVoteToRanking.isEnabled


        }

    }

    private fun clickBadIcon() {
        binding.ivVoteBad.setOnClickListener {
            binding.ivVoteBad.setImageResource(R.drawable.img_bad_click)
            binding.btnVoteToHome.isEnabled
            binding.btnVoteToRanking.isEnabled

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
}



