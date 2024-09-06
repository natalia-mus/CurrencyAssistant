package com.example.currencyassistant.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup

open class Dialog(
    context: Context,
    private val mainViewId: Int,
    private val dialogWidth: Float? = null,
    private val dialogHeight: Float? = null
) : Dialog(context) {

    companion object {
        private const val DESIGN_HEIGHT = 731f
        private const val DESIGN_WIDTH = 430f
        private const val DEFAULT_WIDTH = 400f
        private const val DEFAULT_HEIGHT = ViewGroup.LayoutParams.MATCH_PARENT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDimensions()
    }

    private fun setDimensions() {
        val dialogWindow = findViewById<View>(mainViewId)
        val layoutParams = dialogWindow.layoutParams
        layoutParams.width = if (dialogWidth != null) calcHorizontal(dialogWidth) else calcHorizontal(DEFAULT_WIDTH)
        layoutParams.height = if (dialogHeight != null) calcVertical(dialogHeight) else DEFAULT_HEIGHT
    }

    /**
     * Calculates horizontal dimension according to the device width in order to keep element's scale
     */
    private fun calcHorizontal(value: Float): Int {
        val dpWidth = context.resources.displayMetrics.widthPixels
        return (dpWidth * (value / DESIGN_WIDTH)).toInt()
    }

    /**
     * Calculates vertical dimension according to the device height in order to keep element's scale
     */
    private fun calcVertical(value: Float): Int {
        val dpHeight = context.resources.displayMetrics.heightPixels
        return (dpHeight * (value / DESIGN_HEIGHT)).toInt()
    }
}