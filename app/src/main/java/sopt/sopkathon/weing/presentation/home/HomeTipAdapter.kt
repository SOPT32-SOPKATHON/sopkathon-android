package sopt.sopkathon.weing.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import sopt.sopkathon.weing.data.remote.api.ResponsePreventionDto
import sopt.sopkathon.weing.databinding.ItemHomeTipBinding

class HomeTipAdapter() :
    ListAdapter<ResponsePreventionDto, HomeTipAdapter.HomeTipViewHolder>(HomeTipDiffCallBack()) {
    class HomeTipViewHolder(private val binding: ItemHomeTipBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tipData: ResponsePreventionDto) {
//            binding.data = tipData
            binding.tvHomeItemTitle.text = tipData.title
            binding.tVHomeItemBody.text = tipData.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTipViewHolder {
        val binding = ItemHomeTipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeTipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeTipViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class HomeTipDiffCallBack : DiffUtil.ItemCallback<ResponsePreventionDto>() {
    override fun areItemsTheSame(oldItem: ResponsePreventionDto, newItem: ResponsePreventionDto): Boolean {
        return oldItem== newItem
    }

    override fun areContentsTheSame(oldItem: ResponsePreventionDto, newItem: ResponsePreventionDto): Boolean {
        return oldItem == newItem
    }
}