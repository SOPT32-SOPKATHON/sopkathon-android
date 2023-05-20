package sopt.sopkathon.weing.presentation.ranking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.sopkathon.weing.databinding.ItemRankingBinding
import sopt.sopkathon.weing.domain.model.OutOfRanking

class RankingAdapter : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {
    private val rankItems: MutableList<OutOfRanking> = mutableListOf()

    class RankingViewHolder(private val binding: ItemRankingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ranking: OutOfRanking) {
            binding.outOfRanking = ranking
        }

        companion object {

            fun getView(parent: ViewGroup, layoutInflater: LayoutInflater): ItemRankingBinding =
                ItemRankingBinding.inflate(layoutInflater, parent, false)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return RankingViewHolder(RankingViewHolder.getView(parent, layoutInflater))
    }

    override fun getItemCount(): Int = rankItems.size

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.bind(rankItems[position])
    }

    fun initData(items: List<OutOfRanking>) {
        rankItems.clear()
        rankItems.addAll(items)

        notifyDataSetChanged()
    }
}
