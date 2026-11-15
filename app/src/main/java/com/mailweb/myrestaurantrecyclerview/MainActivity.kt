package com.mailweb.myrestaurantrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMenu: RecyclerView
    private val list = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvMenu = findViewById(R.id.rv_menu)
        rvMenu.setHasFixedSize(true)

        list.addAll(getListMenu())
        showRecyclerList()
        }

    private fun getListMenu(): ArrayList<Menu> {
        val dataName = resources.getStringArray(R.array.menu_name)
        val dataDescription = resources.getStringArray(R.array.menu_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_poto)
        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataName[i], dataDescription[i], dataPhoto.getResourceId(i,-1))
            listMenu.add(menu)
        }
        return listMenu
    }

    private fun showRecyclerList() {
        rvMenu.layoutManager = LinearLayoutManager(this)
        val listMenuAdapter = ListMenuAdapter(list)
        rvMenu.adapter = listMenuAdapter
        }
    }
