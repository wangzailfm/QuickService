package top.jowanxu.quicktilesetting

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.service.quicksettings.TileService
import android.widget.Toast
import top.jowanxu.quicktilesetting.constant.Constant.WECHAT_SCANNER_PARAM_NAME
import java.io.DataOutputStream


/**
 * startActivityAndCollapse启动
 * @param pkgName         包名
 * *
 * @param pkgActivityName 启动的Activity
 * *
 * @param isWeChat        启动微信需要加个参数
 */
fun TileService.startOtherActivity(pkgName: String, pkgActivityName: String, isWeChat: Boolean) {
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

fun TileService.startActivityByScheme(scheme: String) {
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

fun Context.hasAppExist(context: Context, pkgName: String, toastInt: Int): Boolean {
    // 判断是否存在
    if (!isPkgInstalled(context, pkgName)) {
        Toast.makeText(context, getString(toastInt), Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

/**
 * adb启动activity
 * @param context         Context
 * *
 * @param pkgName         包名
 * *
 * @param pkgActivityName 启动的activity
 */
fun startActivity(context: Context, pkgName: String, pkgActivityName: String) {
    var process: Process? = null
    var os: DataOutputStream? = null
    try {
        val cmd = "am start -n $pkgName/$pkgActivityName"
        //切换到root帐号
        process = Runtime.getRuntime().exec("su")
        os = DataOutputStream(process!!.outputStream)
        os.writeBytes(cmd + "\n")
        os.writeBytes("exit\n")
        os.flush()
        process.waitFor()
    } catch (e: Exception) {
        Toast.makeText(context, "启动Activity失败" + e.toString(), Toast.LENGTH_SHORT).show()
    } finally {
        try {
            if (os != null) {
                os.close()
            }
            if (process != null) {
                process.destroy()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

/**
 * 判断相应包名的apk是否存在

 * @param context     Context
 * *
 * @param packageName 包名
 * *
 * @return true存在
 */
fun isPkgInstalled(context: Context, packageName: String?): Boolean {
    if (packageName == null || "" == packageName) {
        return false
    }
    val info: android.content.pm.ApplicationInfo?
    try {
        info = context.packageManager.getApplicationInfo(packageName, 0)
        return info != null
    } catch (e: Exception) {
        return false
    }

}