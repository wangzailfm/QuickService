package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_MAIN_ACTIVITY_NAME
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_PACKAGE_NAME
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startOtherActivity

class QuickWeChatScanService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断微信是否存在
        if (!hasAppExist(applicationContext, WECHAT_PACKAGE_NAME, R.string.notWeChat)) {
            return
        }
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, true)
    }

}
