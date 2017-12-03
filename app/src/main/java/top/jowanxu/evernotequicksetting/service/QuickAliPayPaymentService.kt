package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService

class QuickAliPayPaymentService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断支付宝是否存在
        if (!hasAppExist(applicationContext, ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return
        }
        startOtherActivity(ALIPAY_PACKAGE_NAME, ALIPAY_PAYMENT_ACTIVITY_NAME, false)
    }

    companion object {
        /**
         * 包名
         */
        private val ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone"
        /**
         * 付款码
         */
        private val ALIPAY_PAYMENT_ACTIVITY_NAME = "com.eg.android.AlipayGphone.FastStartActivity"
    }

}
