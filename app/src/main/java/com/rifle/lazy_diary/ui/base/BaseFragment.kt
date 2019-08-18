package com.rifle.lazy_diary.ui.base

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rifle.lazy_diary.app.InterfaceCallback
import com.rifle.lazy_diary.model.WeatherBean
import yalantis.com.sidemenu.interfaces.ScreenShotable

abstract class BaseFragment : androidx.fragment.app.Fragment(), InterfaceCallback, ScreenShotable {
    var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return if (setLayout() == 0) {
            super.onCreateView(inflater, container, savedInstanceState)
        } else {
            inflater.inflate(setLayout(), null)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected abstract fun setLayout(): Int

    protected abstract fun initView()

    override fun sucGetWeather(weatherBean: WeatherBean) {}

    override fun failGetWeather() {}

    override fun failed() {}

    override fun takeScreenShot() {}

    override fun getBitmap(): Bitmap? = null
}