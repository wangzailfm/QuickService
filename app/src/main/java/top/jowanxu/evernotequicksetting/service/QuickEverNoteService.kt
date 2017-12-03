package top.jowanxu.evernotequicksetting.service

import top.jowanxu.evernotequicksetting.R
import top.jowanxu.evernotequicksetting.base.BaseTileService

class QuickEverNoteService : BaseTileService() {

    override fun onClick() {
        super.onClick()
        // 判断EverNote是否存在
        if (!hasAppExist(applicationContext, EVERNOTE_PACKAGE_NAME, R.string.notEverNote)) {
            return
        }
        startOtherActivity(EVERNOTE_PACKAGE_NAME, EVERNOTE_MAIN_ACTIVITY_NAME, false)
    }

    companion object {
        /**
         * 包名
         */
        private val EVERNOTE_PACKAGE_NAME = "com.evernote"
        /**
         * 主界面
         */
        private val EVERNOTE_MAIN_ACTIVITY_NAME = "com.evernote.ui.phone.NewPhoneMainActivity"
    }

}
