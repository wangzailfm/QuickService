package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;

public class QuickAliPayPaymentService extends BaseTileService {
    /**
     * 包名
     */
    private static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    /**
     * 付款码
     */
    private static final String ALIPAY_PAYMENT_ACTIVITY_NAME = "com.eg.android.AlipayGphone.FastStartActivity";

    @Override
    public void onClick() {
        super.onClick();
        // 判断支付宝是否存在
        if (!hasAppExist(getApplicationContext(), ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return;
        }
        startOtherActivity(ALIPAY_PACKAGE_NAME, ALIPAY_PAYMENT_ACTIVITY_NAME, false);
    }

}
