package com.padc.batch9.assignment9.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.adapter.PlantDataAdapter
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.mvp.presenter.PlantListPresenter
import com.padc.batch9.assignment9.mvp.view.PlantListView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), PlantListView{

    override fun displayEventList(plantList: List<PlantVo>) {
        mAdapter.setNewData(plantList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(plantId: String) {

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
        mPresenter = PlantListPresenter()
        mPresenter.initPresenter(this)
        mAdapter = PlantDataAdapter(mPresenter)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter

        mPresenter.onCreate()

        return root
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