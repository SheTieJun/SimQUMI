package me.shetj.qumidemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import me.shetj.qmui.layout.QMUILayoutHelper
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

        test_seekbar_alpha.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mShadowAlpha = progress * 1f / 100
                alpha_tv.text = "alpha: $mShadowAlpha"
                layout_for_test.setRadiusAndShadow(
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

        test_seekbar_elevation.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mShadowElevationDp = progress
                elevation_tv.text = "elevation: " + progress + "dp"
                layout_for_test.setRadiusAndShadow(
                    mRadius,
                    QMUIDisplayHelper.dp2px(this@MainActivity, mShadowElevationDp), mShadowAlpha
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        test_seekbar_alpha.progress = (mShadowAlpha * 100).toInt()
        test_seekbar_elevation.progress = mShadowElevationDp

        hide_radius_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.hide_radius_none -> layout_for_test.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE
                )
                R.id.hide_radius_left -> layout_for_test.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_LEFT
                )
                R.id.hide_radius_top -> layout_for_test.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_TOP
                )
                R.id.hide_radius_bottom -> layout_for_test.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_BOTTOM
                )
                R.id.hide_radius_right -> layout_for_test.setRadius(
                    mRadius,
                    QMUILayoutHelper.HIDE_RADIUS_SIDE_RIGHT
                )
            }
        }

        layout_for_test.radius =   QMUIDisplayHelper.dp2px(this@MainActivity, 15)
    }
}
