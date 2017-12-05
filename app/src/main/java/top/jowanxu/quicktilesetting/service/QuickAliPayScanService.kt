package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.constant.Constant.ALIPAY_PACKAGE_NAME
import top.jowanxu.quicktilesetting.constant.Constant.ALIPAY_QR_SCHEME
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startActivityByScheme

class QuickAliPayScanService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断支付宝是否存在
        if (!hasAppExist(applicationContext, ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return
        }
        startActivityByScheme(ALIPAY_QR_SCHEME)
    }
}
