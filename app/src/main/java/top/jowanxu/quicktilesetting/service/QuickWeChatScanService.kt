package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.constant.Constant
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startOtherActivity

class QuickWeChatScanService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断微信是否存在
        hasAppExist(Constant.WECHAT_PACKAGE_NAME, R.string.notWeChat) ?: return
        startOtherActivity(Constant.WECHAT_PACKAGE_NAME, Constant.WECHAT_MAIN_ACTIVITY_NAME, true)
    }

}
