package com.runle.fooddoor.presentation.fragment.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.PartialItemIntroBinding

/**
 * Created by elnur on 15.11.21
 */
class IntroAdapter() : PagerAdapter() {

    private val titles = listOf(R.string.title_one,R.string.title_two,R.string.title_three,R.string.title_four)
    private val description = listOf(R.string.title_one_desc,R.string.title_two_desc,R.string.title_three_desc,R.string.title_four_desc)
    private val icons = listOf(R.drawable.test,R.drawable.test1,R.drawable.test2,R.drawable.test3)

    var list: List<IntroModel> = listOf(
        IntroModel(title = titles[0], description = description[0],icon = icons[0]),
        IntroModel(title = titles[1], description = description[1],icon = icons[1]),
        IntroModel(title = titles[2], description = description[2],icon = icons[2]),
        IntroModel(title = titles[3], description = description[3],icon = icons[3])
    )

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val model = list[position]
        val binding: PartialItemIntroBinding = PartialItemIntroBinding.inflate( LayoutInflater.from(collection.context), collection, false)
        binding.model = model
        collection.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(collection: ViewGroup, position: Int, `object`: Any) {
        collection.removeView(`object` as View?)
    }
    override fun getCount(): Int {
        return list.size
    }

}