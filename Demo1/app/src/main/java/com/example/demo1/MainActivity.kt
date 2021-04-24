package com.example.demo1

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var listImg = ArrayList<Any>()
    var listTitle = ArrayList<String>()
    var listDate = ArrayList<String>()

    var listPlace = ArrayList<Places>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView_places.setHasFixedSize(true)
        var layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView_places.layoutManager = layoutManager

        var placeContent = PlaceContent()
        listImg.addAll(placeContent.listImg)
        listTitle.addAll(placeContent.listTitle)
        listDate.addAll(placeContent.listDate)

        for (i in 0 until listTitle.size) {
            listPlace.add(Places(listImg[i], listTitle[i], listDate[i]))
        }

        var adapter = PlacesAdapter(listPlace)
        recyclerView_places.adapter = adapter

        adapter.setOnItemClickListener(object : PlacesAdapter.ClickListener {
            override fun onItemClick(position: Int, v: View) {
                var item = listPlace[position]

                var bottomSheetPlace = BottomSheetPlace(item.title, item.date, this@MainActivity)
                bottomSheetPlace.show(supportFragmentManager, bottomSheetPlace.tag)
            }
        })
    }
}