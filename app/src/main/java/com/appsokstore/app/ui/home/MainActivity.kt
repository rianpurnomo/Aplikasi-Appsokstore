package com.appsokstore.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.appsokstore.app.R
import com.appsokstore.app.databinding.ActivityAuthBinding
import com.appsokstore.app.databinding.ActivityMainBinding
import com.appsokstore.app.ui.auth.AppsokstoreAuth
import com.appsokstore.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.bottonNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_warta -> navigate(R.id.wartaFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_provile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}