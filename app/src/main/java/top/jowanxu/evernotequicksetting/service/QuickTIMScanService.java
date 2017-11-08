package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;
import top.jowanxu.evernotequicksetting.utils.Utils;

public class QuickTIMScanService extends BaseTileService {
    /**
     * 包名
     */
    private static final String TIM_PACKAGE_NAME = "com.tencent.tim";
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
        // 判断TIM是否存在
        if (!hasAppExist(getApplicationContext(), TIM_PACKAGE_NAME, R.string.notTim)) {
            return;
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(TIM_PACKAGE_NAME, TIM_MAIN_ACTIVITY_NAME, false);
        // 然后通过命令启动
        Utils.startActivity(getApplicationContext(), TIM_PACKAGE_NAME, TIM_SCANNER_ACTIVITY_NAME);
    }

}
