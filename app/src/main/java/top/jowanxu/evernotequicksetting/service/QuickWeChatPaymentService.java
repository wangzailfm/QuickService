package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;
import top.jowanxu.evernotequicksetting.utils.Utils;

public class QuickWeChatPaymentService extends BaseTileService {
    /**
     * 包名
     */
    private static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
    /**
     * 主界面
     */
    private static final String WECHAT_MAIN_ACTIVITY_NAME = "com.tencent.mm.ui.LauncherUI";
    /**
     * 付款码
     */
    private static final String WECHAT_PAYMENT_ACTIVITY_NAME = "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI";

    @Override
    public void onClick() {
        super.onClick();
        // 判断微信是否存在
        if (!hasAppExist(getApplicationContext(), WECHAT_PACKAGE_NAME, R.string.notWeChat)) {
            return;
        }
        // 先启动主界面，隐藏下拉
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, false);
        // 然后通过命令启动
        Utils.startActivity(getApplicationContext(), WECHAT_PACKAGE_NAME, WECHAT_PAYMENT_ACTIVITY_NAME);
    }

}
