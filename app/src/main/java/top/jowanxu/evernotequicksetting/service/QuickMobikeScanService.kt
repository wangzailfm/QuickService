package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService
import top.jowanxu.evernotequicksetting.utils.Utils

class QuickMobikeScanService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断摩拜是否存在
        if (!hasAppExist(applicationContext, MOBIKE_PACKAGE_NAME, R.string.notMobike)) {
            return
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(MOBIKE_PACKAGE_NAME, MOBIKE_MAIN_ACTIVITY_NAME, false)
        // 然后通过命令启动
        Utils.startActivity(applicationContext, MOBIKE_PACKAGE_NAME, MOBIKE_SCANNER_ACTIVITY_NAME)
    }

    companion object {
        /**
         * 包名
         */
        private val MOBIKE_PACKAGE_NAME = "com.mobike.mobikeapp"
        /**
         * 主界面
         */
        private val MOBIKE_MAIN_ACTIVITY_NAME = "com.mobike.mobikeapp.MainActivity"
        /**
         * 扫一扫
         */
        private val MOBIKE_SCANNER_ACTIVITY_NAME = "com.mobike.mobikeapp.activity.riding.QRCodeScannerActivity"
    }

}
