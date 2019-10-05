package com.padc.batch9.assignment9.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import coil.api.load
import coil.transform.CircleCropTransformation
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.mvp.presenter.PlantDetailPresenter
import com.padc.batch9.assignment9.mvp.view.PlantDetailView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_detail)

        mPresenter = PlantDetailPresenter()
        mPresenter.initPresenter(this)

        val id = intent.getStringExtra(IE_PLANT_ID)

        Log.i("id", "id$id")

        mPresenter.onUIReady(id)
        mPresenter.onCreate()

        imgvBack.setOnClickListener {navigaeBack()}
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

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
