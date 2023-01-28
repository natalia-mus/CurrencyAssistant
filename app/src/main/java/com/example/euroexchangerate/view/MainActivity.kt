package com.example.euroexchangerate.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.euroexchangerate.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.activity_main_bottomNavigation)

        setOnNavigationItemSelectedListener()
        changeFragment(RatesFragment())
    }

    private fun setOnNavigationItemSelectedListener() {
        navigation.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.rates -> changeFragment(RatesFragment())
                R.id.converter -> changeFragment(CurrencyConverterFragment())
            }

            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main_fragment, fragment)
            commit()
        }
    }

}