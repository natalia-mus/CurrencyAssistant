package com.example.euroexchangerate.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_change_default_currency -> {
                openChangeDefaultCurrencyDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openChangeDefaultCurrencyDialog() {
        val dialog = Dialog(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.currency_picker, findViewById(R.id.currency_picker))
        dialog.setContentView(dialogView)
        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onPrepareOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
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