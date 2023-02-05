package com.example.lovecalculatorhiltdi.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculatorhiltdi.R
import com.example.lovecalculatorhiltdi.databinding.ItemOnboardBinding

class onBoardAdapter(private val context: Context, private val onClick: () -> Unit) :
    RecyclerView.Adapter<onBoardAdapter.onBoardingViewHolder>() {
    private val model = arrayListOf<modelOnBoard>(
        modelOnBoard(R.raw.splash_screen, ""),
        modelOnBoard(R.raw.love_1, ""),
        modelOnBoard(R.raw.love_2, ""),
        modelOnBoard(R.raw.heart, "")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int {
        return model.size
    }

    inner class onBoardingViewHolder(private val binding: ItemOnboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelOnBoard: modelOnBoard) {
            binding.imgBoarding.setAnimation(modelOnBoard.image)
            binding.tvTitles.text = modelOnBoard.titles
            if (adapterPosition == model.lastIndex) {
                binding.skip.text = "Next"
            } else binding.skip.text = "Skip"
            binding.skip.setOnClickListener {
                onClick()
            }

        }

    }
}