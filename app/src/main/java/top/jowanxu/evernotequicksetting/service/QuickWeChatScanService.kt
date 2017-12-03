package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService

class QuickWeChatScanService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断微信是否存在
        if (!hasAppExist(applicationContext, WECHAT_PACKAGE_NAME, R.string.notWeChat)) {
            return
        }
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, true)
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
    }

}
