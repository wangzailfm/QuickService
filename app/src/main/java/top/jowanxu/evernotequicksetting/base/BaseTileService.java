package top.jowanxu.evernotequicksetting.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import top.jowanxu.evernotequicksetting.utils.Utils;

/**
 * BaseTileService
 */
public class BaseTileService extends TileService {
    /**
     * 扫一扫传参数
     */
    private static final String WECHAT_SCANNER_PARAM_NAME = "LauncherUI.From.Scaner.Shortcut";

    /**
     * 判断app是否存在
     *
     * @param context  Context
     * @param pkgName  包名
     * @param toastInt Toast
     * @return boolean
     */
    protected boolean hasAppExist(Context context, String pkgName, int toastInt) {
        // 判断是否存在
        if (!Utils.isPkgInstalled(context, pkgName)) {
            Toast.makeText(context, getString(toastInt), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * startActivityAndCollapse启动
     *
     * @param pkgName         包名
     * @param pkgActivityName 启动的Activity
     * @param isWeChat        启动微信需要加个参数
     */
    protected void startOtherActivity(String pkgName, String pkgActivityName, boolean isWeChat) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName component = new ComponentName(pkgName, pkgActivityName);
        intent.setComponent(component);
        if (isWeChat) {
            // 微信如果在其他界面的话需要使用FLAG_ACTIVITY_CLEAR_TOP
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra(WECHAT_SCANNER_PARAM_NAME, true);
        }
        intent.setAction("android.intent.action.VIEW");
        try {
            startActivityAndCollapse(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过scheme启动activity
     * @param scheme scheme
     */
    protected  void startActivityByScheme(String scheme) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri uri = Uri.parse(scheme);
        intent.setData(uri);
        try {
            startActivityAndCollapse(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
