package com.iegb.travel_peru

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = android.graphics.Color.BLACK

        setContentView(R.layout.inicio_activity)
    }
}