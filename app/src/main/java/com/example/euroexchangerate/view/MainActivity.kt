package com.example.euroexchangerate.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.euroexchangerate.R
import com.example.euroexchangerate.Settings
import com.example.euroexchangerate.data.Currency
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), OnCurrencyChangedAction {

    lateinit var navigation: BottomNavigationView

    private var currentFragment: CurrencyFragment = RatesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.activity_main_bottomNavigation)
        Settings.init(this)

        setOnNavigationItemSelectedListener()
        changeFragment(currentFragment)
    }

    override fun changeCurrency(currency: Currency) {
        Settings.changeDefaultCurrency(currency)
        currentFragment.onBaseCurrencyChanged()
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
        val actualDefaultCurrency = Settings.getDefaultCurrency()
        val currencyPicker = CurrencyPicker(this, actualDefaultCurrency, this)
        currencyPicker.show()
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

    private fun changeFragment(fragment: CurrencyFragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main_fragment, fragment)
            commit()
        }
        currentFragment = fragment
    }

}