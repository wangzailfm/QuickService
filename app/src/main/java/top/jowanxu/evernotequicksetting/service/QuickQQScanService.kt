package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService
import top.jowanxu.evernotequicksetting.utils.Utils

class QuickQQScanService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断QQ是否存在
        if (!hasAppExist(applicationContext, QQ_PACKAGE_NAME, R.string.notQQ)) {
            return
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(QQ_PACKAGE_NAME, TIM_MAIN_ACTIVITY_NAME, false)
        // 然后通过命令启动
        Utils.startActivity(applicationContext, QQ_PACKAGE_NAME, TIM_SCANNER_ACTIVITY_NAME)
    }

    companion object {
        /**
         * 包名
         */
        val QQ_PACKAGE_NAME = "com.tencent.mobileqq"
        /**
         * 主界面
         */
        private val TIM_MAIN_ACTIVITY_NAME = "com.tencent.mobileqq.activity.SplashActivity"
        /**
         * 扫一扫
         */
        private val TIM_SCANNER_ACTIVITY_NAME = "com.tencent.biz.qrcode.activity.ScannerActivity"
    }

}
