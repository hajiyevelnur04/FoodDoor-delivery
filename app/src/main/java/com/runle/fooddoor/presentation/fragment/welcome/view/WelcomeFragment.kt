package com.runle.fooddoor.presentation.fragment.welcome.view

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.runle.fooddoor.R
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.WelcomeFragmentBinding
import com.runle.fooddoor.presentation.fragment.welcome.model.WelcomeModel
import com.runle.fooddoor.presentation.fragment.welcome.util.convertLongArrayListToLongArray
import com.runle.fooddoor.presentation.fragment.welcome.viewholder.StoriesProgressView


/**
 * Created by elha on 10.08.2021.
 */
class WelcomeFragment: Fragment(), StoriesProgressView.StoriesListener, WelcomeView {

    private var counter = 0
    var pressTime = 0L
    var limit = 500L

    private val durations = arrayListOf<Long>()

    lateinit var welcomeModels: List<WelcomeModel>

    private val safeArgs by navArgs<WelcomeFragmentArgs>()

    var progressCount: Int  = 0


    private val onTouchListener: View.OnTouchListener = object : View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    pressTime = System.currentTimeMillis()
                    binding.stories.pause()
                    return false
                }
                MotionEvent.ACTION_UP -> {
                    val now = System.currentTimeMillis()
                    binding.stories.resume()
                    return limit < now - pressTime
                }
            }
            return false
        }
    }


    private val binding: WelcomeFragmentBinding by lazy {
        WelcomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().window.navigationBarColor = requireActivity().resources.getColor(R.color.bg_white)
        requireActivity().window.statusBarColor = requireActivity().resources.getColor(R.color.bg_white)

        welcomeModels = safeArgs.welcomeModels
        binding.getStarted.setOnClickListener {
            closeFragment()
        }

        //animateBackground(binding.container)
        // iterate through welcome models
        iterateWelcomeModel()
        initStories()
        initClickListener()

        return binding.root
    }

    private fun initClickListener() {
        // bind reverse view
        binding.reverse.setOnClickListener { binding.stories.reverse() }
        binding.reverse.setOnTouchListener(onTouchListener)

        // bind skip view
        binding.skip.setOnClickListener { binding.stories.skip() }
        binding.skip.setOnTouchListener(onTouchListener)

    }

    private fun initStories() {
        binding.stories.setStoriesCount(progressCount); // <- set stories
        binding.stories.setStoriesCountWithDurations(convertLongArrayListToLongArray(durations)); // <- set a story duration
        binding.stories.setStoriesListener(this); // <- set listener
        binding.stories.startStories() // <- start progress

        setViewByCounter(0)
    }

    private fun closeFragment() {
        findNavController().popBackStack()
    }

    private fun animateBackground(constraintLayout: ConstraintLayout) {
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(8000)
        animationDrawable.setExitFadeDuration(1600)
        animationDrawable.start()
    }

    private fun iterateWelcomeModel() {
        for (welcomeModel in welcomeModels) {
            durations.add(welcomeModel.duration)
        }
    }

    private fun setViewByCounter(counter: Int) {
        binding.welcomeModel = welcomeModels[counter]
        binding.lastPageContainer.visibility = if (counter + 1 == welcomeModels.size) View.VISIBLE else View.GONE
        binding.info.visibility = if (counter + 1 == welcomeModels.size) View.GONE else View.VISIBLE
    }


    override fun onComplete() {
        // start again
        counter = 0
        closeFragment()
    }

    override fun onPrev() {
        if (counter - 1 < 0) return
        setViewByCounter(--counter)
    }

    override fun onNext() {
        setViewByCounter(++counter)
    }

    override fun onDestroy() {
        binding.stories.destroy()
        super.onDestroy()
    }

}