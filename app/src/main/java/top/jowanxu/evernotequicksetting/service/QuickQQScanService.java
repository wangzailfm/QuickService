package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;
import top.jowanxu.evernotequicksetting.utils.Utils;

public class QuickQQScanService extends BaseTileService {
    /**
     * 包名
     */
    public static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    /**
     * 主界面
     */
    private static final String TIM_MAIN_ACTIVITY_NAME = "com.tencent.mobileqq.activity.SplashActivity";
    /**
     * 扫一扫
     */
    private static final String TIM_SCANNER_ACTIVITY_NAME = "com.tencent.biz.qrcode.activity.ScannerActivity";

    @Override
    public void onClick() {
        super.onClick();
        // 判断QQ是否存在
        if (!hasAppExist(getApplicationContext(), QQ_PACKAGE_NAME, R.string.notQQ)) {
            return;
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(QQ_PACKAGE_NAME, TIM_MAIN_ACTIVITY_NAME, false);
        // 然后通过命令启动
        Utils.startActivity(getApplicationContext(), QQ_PACKAGE_NAME, TIM_SCANNER_ACTIVITY_NAME);
    }

}
