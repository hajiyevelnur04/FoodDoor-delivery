package com.runle.fooddoor.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.runle.fooddoor.R
import com.runle.fooddoor.data.enums.Status
import com.runle.fooddoor.util.MultiStateView
import com.runle.fooddoor.util.ViewState
import com.runle.fooddoor.view.TagLayout
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
fun ImageView.bindImageUrl(url: Any?) {
    Glide.with(this.context).load(url ?: R.drawable.bg).into(this)
}

@BindingAdapter(value = ["setImgDrawable"])
fun ImageView.bindImageResource(resource: Int?) {
    if (resource != null) {
        Glide.with(this.context).load(resource).into(this)
    }
}

@BindingAdapter(value = ["status", "brandError", "emptyData", "tags"], requireAll = false)
fun MultiStateView.changeStatus(status: Status?, brandError: String?, emptyData: String?, tags: List<String>?) {

    if (status == null) {
        this.viewState = ViewState.CONTENT
        return
    }


    val multiState: ViewState = when (status) {

        Status.SUCCESS -> ViewState.CONTENT
        Status.LOADING -> ViewState.LOADING
        Status.NETWORK -> ViewState.NETWORK
        Status.ERROR -> ViewState.CONTENT
        Status.EMPTY -> ViewState.EMPTY
        Status.TAG -> ViewState.TAG
    }

    this.viewState = multiState

    if (multiState == ViewState.EMPTY && !emptyData.isNullOrEmpty()) {

        this.getView(multiState)?.findViewById<TextView>(R.id.titleTxt)?.text = emptyData
    }


    if (multiState == ViewState.TAG && !tags.isNullOrEmpty()) {
        val tagLayout = this.getView(multiState)?.findViewById<TagLayout>(R.id.tagLayout)
        tags.forEach {
            val tagTextView = this.getView(multiState)?.findViewById<TextView>(R.id.tagTextView)
            tagTextView?.text = it
            tagLayout?.addView(tagTextView)
        }
    }

    when (status) {
        Status.NETWORK, Status.ERROR -> {
            //this.snackBar(this, brandError)

        }
        else -> return
    }
}