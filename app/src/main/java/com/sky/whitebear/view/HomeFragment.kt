package com.sky.whitebear.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sky.whitebear.R
import com.sky.whitebear.util.Account
import com.sky.whitebear.util.Data

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.main, container, false)
        var text = view.findViewById<TextView>(R.id.main_title)
        text.setText("home")
        var account = view.findViewById<TextView>(R.id.main_account)
        account.setText("Account: "+ Data().get(Account))


        return view
    }
}