package me.shetj.qumidemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.shetj.qmui.layout.QMUILayoutHelper
import me.shetj.qmui.layout.QMUILinearLayout
import me.shetj.qumi.R

class MainActivity : AppCompatActivity() {

    private var mShadowAlpha = 0.25f
    private var mShadowElevationDp = 14
    private var mRadius: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val layoutForTest = findViewById<QMUILinearLayout>(R.id.layout_for_test)
        val alphaTv = findViewById<TextView>(R.id.alpha_tv)
        val elevationTv = findViewById<TextView>(R.id.elevation_tv)
        mRadius = QMUIDisplayHelper.dp2px(this@MainActivity, 15)
        findViewById<SeekBar>(R.id.test_seekbar_alpha).apply {
            progress = (mShadowAlpha * 100).toInt()
        }.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mShadowAlpha = progress * 1f / 100
                alphaTv.text = "alpha: $mShadowAlpha"
                layoutForTest.setRadiusAndShadow(
                    mRadius,
                    QMUIDisplayHelper.dp2px(this@MainActivity, mShadowElevationDp),
                    mShadowAlpha
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        findViewById<SeekBar>(R.id.test_seekbar_elevation).apply {
            progress = mShadowElevationDp
        }.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mShadowElevationDp = progress
                elevationTv.text = "elevation: " + progress + "dp"
                layoutForTest.setRadiusAndShadow(
                    mRadius,
                    QMUIDisplayHelper.dp2px(this@MainActivity, mShadowElevationDp), mShadowAlpha
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })


        findViewById<RadioGroup>(R.id.hide_radius_group).setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.hide_radius_none -> layoutForTest.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE
                )
                R.id.hide_radius_left -> layoutForTest.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_LEFT
                )
                R.id.hide_radius_top -> layoutForTest.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_TOP
                )
                R.id.hide_radius_bottom -> layoutForTest.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_BOTTOM
                )
                R.id.hide_radius_right -> layoutForTest.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_RIGHT
                )
            }
        }

        findViewById<View>(R.id.shadow_color_red).setOnClickListener {
            layoutForTest.shadowColor = Color.RED
        }

        findViewById<View>(R.id.shadow_color_blue).setOnClickListener {
            layoutForTest.shadowColor = Color.BLUE
        }
    }
}
