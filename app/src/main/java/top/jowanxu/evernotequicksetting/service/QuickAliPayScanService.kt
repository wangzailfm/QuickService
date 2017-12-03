package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService

class QuickAliPayScanService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断支付宝是否存在
        if (!hasAppExist(applicationContext, ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return
        }
        startActivityByScheme(ALIPAY_QR_SCHEME)
    }

    companion object {
        /**
         * 包名
         */
        private val ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone"
        /**
         * 扫一扫scheme
         * 付款 alipays://platformapi/startapp?appId=20000056
         */
        private val ALIPAY_QR_SCHEME = "alipayqr://platformapi/startapp?saId=10000007"
    }

}
