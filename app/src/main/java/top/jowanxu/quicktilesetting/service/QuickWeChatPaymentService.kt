package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_MAIN_ACTIVITY_NAME
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_PACKAGE_NAME
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_PAYMENT_ACTIVITY_NAME
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startActivity
import top.jowanxu.quicktilesetting.startOtherActivity

class QuickWeChatPaymentService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断微信是否存在
        hasAppExist(WECHAT_PACKAGE_NAME, R.string.notWeChat) ?: return
        // 先启动主界面，隐藏下拉
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, false)
        // 然后通过命令启动
        startActivity(applicationContext, WECHAT_PACKAGE_NAME, WECHAT_PAYMENT_ACTIVITY_NAME)
    }
}
