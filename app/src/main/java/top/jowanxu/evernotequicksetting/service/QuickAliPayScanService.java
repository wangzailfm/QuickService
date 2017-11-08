package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;

public class QuickAliPayScanService extends BaseTileService {
    /**
     * 包名
     */
    private static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    /**
     * 扫一扫scheme
     * 付款 alipays://platformapi/startapp?appId=20000056
     */
    private static final String ALIPAY_QR_SCHEME = "alipayqr://platformapi/startapp?saId=10000007";

    @Override
    public void onClick() {
        super.onClick();
        // 判断支付宝是否存在
        if (!hasAppExist(getApplicationContext(), ALIPAY_PACKAGE_NAME, R.string.notAliPay)) {
            return;
        }
        startActivityByScheme(ALIPAY_QR_SCHEME);
    }

}
