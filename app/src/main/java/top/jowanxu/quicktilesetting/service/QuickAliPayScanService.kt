package top.jowanxu.quicktilesetting.service

import android.service.quicksettings.TileService
import top.jowanxu.quicktilesetting.R
import top.jowanxu.quicktilesetting.constant.Constant
import top.jowanxu.quicktilesetting.hasAppExist
import top.jowanxu.quicktilesetting.startActivityByScheme

class QuickAliPayScanService : TileService() {

    override fun onClick() {
        super.onClick()
        // 判断支付宝是否存在
        hasAppExist(Constant.ALIPAY_PACKAGE_NAME, R.string.notAliPay) ?: return
        startActivityByScheme(Constant.ALIPAY_QR_SCHEME)
    }
}
