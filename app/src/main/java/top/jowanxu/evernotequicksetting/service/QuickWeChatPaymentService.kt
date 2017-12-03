package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService
import top.jowanxu.evernotequicksetting.utils.Utils

class QuickWeChatPaymentService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断微信是否存在
        if (!hasAppExist(applicationContext, WECHAT_PACKAGE_NAME, R.string.notWeChat)) {
            return
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, false)
        // 然后通过命令启动
        Utils.startActivity(applicationContext, WECHAT_PACKAGE_NAME, WECHAT_PAYMENT_ACTIVITY_NAME)
    }

    companion object {
        /**
         * 包名
         */
        private val WECHAT_PACKAGE_NAME = "com.tencent.mm"
        /**
         * 主界面
         */
        private val WECHAT_MAIN_ACTIVITY_NAME = "com.tencent.mm.ui.LauncherUI"
        /**
         * 付款码
         */
        private val WECHAT_PAYMENT_ACTIVITY_NAME = "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI"
    }

}
