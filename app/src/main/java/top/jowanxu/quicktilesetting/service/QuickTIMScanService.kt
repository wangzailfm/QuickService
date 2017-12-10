package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.constant.Constant
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startActivity
import top.jowanxu.quicktilesetting.startOtherActivity

class QuickTIMScanService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断TIM是否存在
        hasAppExist(Constant.TIM_PACKAGE_NAME, R.string.notTim) ?: return
        // 先启动主界面，隐藏下拉
        startOtherActivity(Constant.TIM_PACKAGE_NAME, Constant.TIM_MAIN_ACTIVITY_NAME, false)
        // 然后通过命令启动
        startActivity(applicationContext, Constant.TIM_PACKAGE_NAME, Constant.TIM_SCANNER_ACTIVITY_NAME)
    }

}
