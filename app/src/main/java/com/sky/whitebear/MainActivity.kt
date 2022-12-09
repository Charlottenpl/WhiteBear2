package com.sky.whitebear

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sky.whitebear.MainActivity.Companion
import com.sky.whitebear.MainActivity.Companion.TAG
import com.sky.whitebear.MainActivity.Companion.context
import com.sky.whitebear.ui.theme.WhiteBearTheme
import com.topjoy.zeussdk.control.ZeusSDK

class MainActivity : ComponentActivity() {

    //静态变量
    companion object {
        lateinit var context: Context
        lateinit var TAG: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = baseContext
        TAG = "MainActivity"
        //设置内容
        setContent {
            WhiteBearTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    initBtn()
                    loginBtn()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun initBtn() {
    var appid = "E7GZ597KPJS4"
    var signKey = "9BR42QW9ABZ4EHY2"
    var service = "https://abroad.topjoy.com/"

    Button(
        onClick = {
            ZeusSDK.getInstance()
                .init(context, appid, signKey, service, true) { resultCode, msg, result ->
                    Log.e(TAG, "init Success")
                }
        },
        modifier = Modifier.fillMaxWidth().height(30.dp),
    ) {
        Text(
            text = "init",
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun loginBtn() {
    Button(
        onClick = {
            ZeusSDK.getInstance().login(false) { resultCode, msg, result ->
                Log.e(TAG, "login Success")
                Log.e(TAG, result)
            }
        },
        modifier = Modifier.fillMaxWidth().height(30.dp),

        ) {
        Text(
            text = "login",
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhiteBearTheme {
        Greeting("Android")
    }
}