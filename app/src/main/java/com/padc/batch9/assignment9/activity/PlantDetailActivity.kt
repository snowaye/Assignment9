package com.padc.batch9.assignment9.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import coil.transform.CircleCropTransformation
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.mvp.presenter.PlantDetailPresenter
import com.padc.batch9.assignment9.mvp.view.PlantDetailView
import com.padc.batch9.assignment9.util.Utils
import kotlinx.android.synthetic.main.activity_plant_detail.*
import kotlinx.android.synthetic.main.activity_plant_detail.rootView
import kotlinx.android.synthetic.main.fragment_home.*

class PlantDetailActivity : BaseActivity(), PlantDetailView {
    override fun displayError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }

    override fun navigaeBack() {
        finish()
    }

    override fun displayPlantData(plantVo: PlantVo) {
        bindData(plantVo)
        loadTipListAnimation()
        loadFavoriteButtonScaleAnimation()
    }

    private lateinit var mPresenter:PlantDetailPresenter

    companion object {
        const val IE_PLANT_ID = "plant_id"

        fun newIntent(context: Context, id:String): Intent {
            return Intent(context, PlantDetailActivity::class.java).apply {
                putExtra(IE_PLANT_ID, id)
            }
        }
    }

    var isFavourite:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_detail)
        Utils.setStatusBarColor(this, R.color.textColorPrimary)
        mPresenter = ViewModelProviders.of(this).get(PlantDetailPresenter::class.java)
        mPresenter.initPresenter(this)

        val id = intent.getStringExtra(IE_PLANT_ID)
        val idSearch = "%"+id

        Log.i("id", "id$id")

        mPresenter.onUIReady(id)

        imgvBack.setOnClickListener {navigaeBack()}

        imgv_favorite.setOnClickListener {
            if (!isFavourite) {
                imgv_favorite.speed = 1.0f
                imgv_favorite.playAnimation()
                isFavourite = true
            }
            else {
                imgv_favorite.speed = -4.0f
                imgv_favorite.playAnimation()
                isFavourite = false
            }
        }
    }

    fun bindData(data:PlantVo) {
        tvPlantName.text = data.plantName
        tvUploadedBy.text = data.uploadedUser.name
        tvDescription.text = data.description
        imgv_post_by.load(data.uploadedUser.userPhoto) {
            crossfade(true)
            crossfade(500)
            transformations(CircleCropTransformation())
            error(R.drawable.ic_avatar)
            placeholder(R.drawable.ic_avatar)
        }
        imgvPlant.load(data.phantPhoto) {
            crossfade(true)
            crossfade(500)
            error(R.drawable.ic_plant)
            placeholder(R.drawable.ic_plant)
        }
        tvTip1Value.text  = data.tips.temperature
        tvTip2Value.text = data.tips.light
        tvTip13Value.text = data.tips.placement
    }

    fun loadTipListAnimation() {
        Handler().postDelayed(Runnable {
            val animation =  AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_from_right)
            tipList.startAnimation(animation)
        }, 1000)
    }

    fun loadFavoriteButtonScaleAnimation() {
        Handler().postDelayed(Runnable {
            imgv_favorite.animate()
                .scaleX(0.5f)
                .scaleY(0.5f)
                .duration = 2000
        }, 1000)
    }
}
