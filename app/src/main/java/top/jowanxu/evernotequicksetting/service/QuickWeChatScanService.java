package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;

public class QuickWeChatScanService extends BaseTileService {
    /**
     * 包名
     */
    private static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
    /**
     * 主界面
     */
    private static final String WECHAT_MAIN_ACTIVITY_NAME = "com.tencent.mm.ui.LauncherUI";

    @Override
    public void onClick() {
        super.onClick();
        // 判断微信是否存在
        if (!hasAppExist(getApplicationContext(), WECHAT_PACKAGE_NAME, R.string.notWeChat)) {
            return;
        }
        startOtherActivity(WECHAT_PACKAGE_NAME, WECHAT_MAIN_ACTIVITY_NAME, true);
    }

}
