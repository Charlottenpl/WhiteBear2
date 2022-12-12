package com.sky.whitebear

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sky.whitebear.util.*
import com.sky.whitebear.view.MainActivity
import com.topjoy.zeussdk.common.MCConstant
import com.topjoy.zeussdk.control.ZeusSDK
import initSuccess
import loginSuccess
import org.json.JSONObject

class LoginActivity : Activity() {

    //静态变量
    companion object {
        lateinit var context: Context
        lateinit var TAG: String
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        TAG = "LoginActivity"
        setContentView(R.layout.login)
        window.statusBarColor = Color.TRANSPARENT
        setLightStatusBar()

        init(findViewById(R.id.img_icon))

    }

    fun init(view: View) {
        var appid = "E7GZ597KPJS4"
        var signKey = "9BR42QW9ABZ4EHY2"
        var service = "https://abroad.topjoy.com/"

        ZeusSDK.getInstance()
            .init(context, appid, signKey, service, true) { resultCode, msg, result ->
                if (resultCode == MCConstant.RESULT_CODE_SUCCESS) {
                    addText("init Success")
                    initSuccess = true
                } else {
                    addText(result)
                }
            }

    }


    fun login(view: View) {
        if (!initSuccess) {
            return
        }
        ZeusSDK.getInstance().login(false) { resultCode, msg, result ->
            if (resultCode == MCConstant.RESULT_CODE_SUCCESS) {
                saveUser(result)
                gotoMain()
                loginSuccess = true
            } else {
                addText(result)
            }
        }
    }

    private fun saveUser(result: String) {
        var json = JSONObject(result).getJSONObject("result")
        var account :String = json.getString("account")
        var id :String = json.getString("id")
        Data().set(Account, account)
        Data().set(UserId, id)
    }

    fun googleLogin(view: View) {
        if (!initSuccess) {
            return
        }
        ZeusSDK.getInstance().loginThird(
            context as Activity?,
            MCConstant.LOGIN_THIRD_TYPE_GOOGLE_ID,
        ) { resultCode, msg, result ->
            if (resultCode == MCConstant.RESULT_CODE_SUCCESS) {
                saveUser(result)
                gotoMain()
            }
        }
    }

    fun facebookLogin(view: View) {
        if (!initSuccess) {
            return
        }
        ZeusSDK.getInstance().loginThird(
            context as Activity?,
            MCConstant.LOGIN_THIRD_TYPE_FACEBOOK,
        ) { resultCode, msg, result ->
            if (resultCode == MCConstant.RESULT_CODE_SUCCESS) {
                saveUser(result)
                gotoMain()
            }
        }
    }

    fun twitterLogin(view: View) {
        if (!initSuccess) {
            return
        }
        ZeusSDK.getInstance().loginThird(
            context as Activity?,
            MCConstant.LOGIN_THIRD_TYPE_TWITTER,
        ) { resultCode, msg, result ->
            if (resultCode == MCConstant.RESULT_CODE_SUCCESS) {
                saveUser(result)
                gotoMain()
            }
        }
    }


    fun gotoMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * 添加log
     */
    fun addText(msg: String) {
        Log.e(TAG, msg)
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
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




