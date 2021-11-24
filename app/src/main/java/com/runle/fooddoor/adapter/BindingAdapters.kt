package com.runle.fooddoor.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.runle.fooddoor.R
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel

@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<ItemViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRecyclerViewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
        recyclerView.adapter as BindableRecyclerViewAdapter
    } else {
        val bindableRecyclerAdapter = BindableRecyclerViewAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}

@BindingAdapter(value = ["setImageUrl"])
fun ImageView.setImageUrl(url: Any) {
    Glide.with(this.context).load(url).error(R.drawable.test_nut).into(this)
}

@BindingAdapter(value = ["setImgDrawable"])
fun ImageView.bindImageResource(resource: Int?) {
    if (resource != null) {
        Glide.with(this.context).load(resource).into(this)
    }
}