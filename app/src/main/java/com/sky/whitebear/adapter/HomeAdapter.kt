package com.sky.whitebear.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sky.whitebear.view.HomeFragment

class HomeAdapter(mfragment: FragmentActivity) : FragmentStateAdapter(mfragment) {
    var fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}