package com.padc.batch9.assignment9.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.activity.BaseActivity
import com.padc.batch9.assignment9.activity.PlantDetailActivity
import com.padc.batch9.assignment9.adapter.PlantDataAdapter
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.mvp.presenter.PlantListPresenter
import com.padc.batch9.assignment9.mvp.view.PlantListView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), PlantListView{
    override fun setExistingList(plantList: List<PlantVo>) {
        mAdapter.setNewData(plantList.toMutableList())
    }

    override fun searchPlant(plantList: List<PlantVo>) {
        mAdapter.setNewData(plantList.toMutableList())
    }


    override fun displayPlantList(plantList: List<PlantVo>) {
        mAdapter.setNewData(plantList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(plantId: String, plantImage:AppCompatImageView) {
        val imagePair = Pair.create(plantImage as View, "tPlantName")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity as BaseActivity, imagePair)
        context?.let {
            ActivityCompat.startActivity(
                it, PlantDetailActivity.newIntent(it, plantId),
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity as BaseActivity).toBundle())
        }
    }

    private lateinit var mPresenter: PlantListPresenter
    private lateinit var mAdapter: PlantDataAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recv_plant)
        val etSearch = root.findViewById<AppCompatEditText>(R.id.et_search)
        mPresenter = ViewModelProviders.of(this).get(PlantListPresenter::class.java)
        mPresenter.initPresenter(this)
        mAdapter = PlantDataAdapter(mPresenter)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter

        etSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty()) {
                    mPresenter.onEditTexyEmpty()
                }
                else {
                    mPresenter.onEditTextTextChange(s.toString().trim())
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        mPresenter.onUIReady(activity as BaseActivity)

        return root
    }

//    private fun setUpAnimationsSlide(){
//        with(activity?.window){
//            activity?.window?.requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS)
//            val slide = Slide()
//            slide.interpolator = android.view.animation.AccelerateDecelerateInterpolator()
//            slide.duration = 1000
//            slide.slideEdge = Gravity.RIGHT
//            enterTransition = slide
//        }
//    }
}