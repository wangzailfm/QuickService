package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.constant.Constant.ALIPAY_PACKAGE_NAME
import top.jowanxu.quicktilesetting.constant.Constant.ALIPAY_PAYMENT_ACTIVITY_NAME
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startOtherActivity

class QuickAliPayPaymentService: TileService() {

    override fun onClick() {
        super.onClick()
        // 判断支付宝是否存在
        if (!hasAppExist(applicationContext, ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return
        }
        startOtherActivity(ALIPAY_PACKAGE_NAME, ALIPAY_PAYMENT_ACTIVITY_NAME, false)
    }

}
