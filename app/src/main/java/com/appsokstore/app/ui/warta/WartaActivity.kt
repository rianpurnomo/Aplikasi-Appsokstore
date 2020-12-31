package com.appsokstore.app.ui.warta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appsokstore.app.R

class WartaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warta)
    }

    companion object {
        const val OPEN_WARTA = "open_warta"
    }
}