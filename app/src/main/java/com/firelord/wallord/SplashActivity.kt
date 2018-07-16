package com.firelord.wallord

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity

class SplashActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashThread=SplashThread()
        splashThread.start()

    }

    inner class SplashThread : Thread() {

        override fun run() {
            sleep(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }

    }
}