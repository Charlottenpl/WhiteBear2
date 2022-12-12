package com.sky.whitebear.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sky.whitebear.LoginActivity
import com.sky.whitebear.R
import com.sky.whitebear.adapter.HomeAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mdata: ArrayList<Fragment>
    private lateinit var viewPager2: ViewPager2
    private lateinit var homeBtn: View
    private lateinit var chatBtn: View
    private lateinit var setBtn: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.TRANSPARENT
        setLightStatusBar()

        initData()
        initView()
    }

    private fun initData() {

    }


    private fun initView() {
        viewPager2 = findViewById<ViewPager2>(R.id.viewpager)
        val myAdapter = HomeAdapter(this)
        myAdapter.fragments.add(HomeFragment())
        myAdapter.fragments.add(ChatFragment())
        myAdapter.fragments.add(SetFragment())
        viewPager2.adapter = myAdapter

        homeBtn = findViewById(R.id.nav_btn_home)
        chatBtn = findViewById(R.id.nav_btn_chat)
        setBtn = findViewById(R.id.nav_btn_set)
        homeBtn.setOnClickListener(this)
        chatBtn.setOnClickListener(this)
        setBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.nav_btn_home -> {
                setItem(0)
            }
            R.id.nav_btn_chat -> {
                setItem(1)
            }
            R.id.nav_btn_set -> {
                setItem(2)
            }
        }
    }


    /**
     * 添加log
     */
    fun addText(msg: String) {
        Log.e(LoginActivity.TAG, msg)
        Toast.makeText(LoginActivity.context, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 点击item按钮
     */
    private fun setItem(item: Int) {
        viewPager2.currentItem = item

    }

    private fun setLightStatusBar() {
        val flags = window.decorView.systemUiVisibility
        window.decorView.systemUiVisibility = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    private fun setDarkStatusBar() {
        val flags = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}