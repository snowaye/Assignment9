package com.padc.batch9.assignment9.fragment

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.activity.ui.gallery.GalleryViewModel

class FavoriteFragment : BaseFragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
        tabLayout = root.findViewById(R.id.tabLayout)
        viewPager = root.findViewById(R.id.viewpager)

        return root
    }

//    private fun setUpAnimationsSlide(){
//        with(activity?.window){
//            activity?.window?.requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS)
//            val slide = Slide()
//            slide.interpolator = android.view.animation.AccelerateDecelerateInterpolator()
//            slide.duration = 1000
//            slide.slideEdge = Gravity.TOP
//            enterTransition = slide
//        }
//    }
}