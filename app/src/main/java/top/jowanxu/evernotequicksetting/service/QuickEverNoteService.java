package top.jowanxu.evernotequicksetting.service;

import top.jowanxu.evernotequicksetting.R;
import top.jowanxu.evernotequicksetting.base.BaseTileService;

public class QuickEverNoteService extends BaseTileService {
    /**
     * 包名
     */
    private static final String EVERNOTE_PACKAGE_NAME = "com.evernote";
    /**
     * 主界面
     */
    private static final String EVERNOTE_MAIN_ACTIVITY_NAME = "com.evernote.ui.phone.NewPhoneMainActivity";

    @Override
    public void onClick() {
        super.onClick();
        // 判断EverNote是否存在
        if (!hasAppExist(getApplicationContext(), EVERNOTE_PACKAGE_NAME, R.string.notEverNote)) {
            return;
        }
        startOtherActivity(EVERNOTE_PACKAGE_NAME, EVERNOTE_MAIN_ACTIVITY_NAME, false);
    }

}
