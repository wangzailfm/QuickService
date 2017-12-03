package top.jowanxu.evernotequicksetting.base

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.service.quicksettings.TileService
import android.widget.Toast

import top.jowanxu.evernotequicksetting.utils.Utils

/**
 * BaseTileService
 */
open class BaseTileService : TileService() {

    /**
     * 判断app是否存在

     * @param context  Context
     * *
     * @param pkgName  包名
     * *
     * @param toastInt Toast
     * *
     * @return boolean
     */
    protected fun hasAppExist(context: Context, pkgName: String, toastInt: Int): Boolean {
        // 判断是否存在
        if (!Utils.isPkgInstalled(context, pkgName)) {
            Toast.makeText(context, getString(toastInt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    /**
     * startActivityAndCollapse启动

     * @param pkgName         包名
     * *
     * @param pkgActivityName 启动的Activity
     * *
     * @param isWeChat        启动微信需要加个参数
     */
    protected fun startOtherActivity(pkgName: String, pkgActivityName: String, isWeChat: Boolean) {
        val intent = Intent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val component = ComponentName(pkgName, pkgActivityName)
        intent.component = component
        if (isWeChat) {
            // 微信如果在其他界面的话需要使用FLAG_ACTIVITY_CLEAR_TOP
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(WECHAT_SCANNER_PARAM_NAME, true)
        }
        intent.action = "android.intent.action.VIEW"
        try {
            startActivityAndCollapse(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 通过scheme启动activity
     * @param scheme scheme
     */
    protected fun startActivityByScheme(scheme: String) {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        val uri = Uri.parse(scheme)
        intent.data = uri
        try {
            startActivityAndCollapse(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        /**
         * 扫一扫传参数
         */
        private val WECHAT_SCANNER_PARAM_NAME = "LauncherUI.From.Scaner.Shortcut"
    }

}
