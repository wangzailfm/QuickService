package top.jowanxu.quicktilesetting

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.service.quicksettings.TileService
import android.widget.Toast
import top.jowanxu.quicktilesetting.constant.Constant
import java.io.DataOutputStream


/**
 * startActivityAndCollapse启动
 * @param pkgName         包名
 * *
 * @param pkgActivityName 启动的Activity
 * *
 * @param isWeChat        启动微信需要加个参数
 */
fun TileService.startOtherActivity(pkgName: String, pkgActivityName: String, isWeChat: Boolean) = try {
    Intent().apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        component = ComponentName(pkgName, pkgActivityName)
        if (isWeChat) {
            // 微信如果在其他界面的话需要使用FLAG_ACTIVITY_CLEAR_TOP
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(Constant.WECHAT_SCANNER_PARAM_NAME, true)
        }
        action = Constant.WECHAT_SCANNER_ACTION_PARAM
        startActivityAndCollapse(this)
    }
} catch (e: Exception) {
    e.printStackTrace()
}

fun TileService.startActivityByScheme(scheme: String) = try {
    Intent().apply {
        action = Constant.WECHAT_SCANNER_ACTION_PARAM
        data = Uri.parse(scheme)
        startActivityAndCollapse(this)
    }
} catch (e: Exception) {
    e.printStackTrace()
}

fun Context.hasAppExist(pkgName: String, toastInt: Int): Boolean?  {
    if (!isPkgInstalled(this, pkgName)) {
        // 判断是否存在
        Toast.makeText(this, getString(toastInt), Toast.LENGTH_SHORT).show()
        return null
    } else {
        return true
    }
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
 * 启动关闭通知栏
 */
@SuppressLint("WrongConstant")
fun Context.collapseStatusBar() = try {
    getSystemService("statusbar")?.let {
        it.javaClass.getMethod("collapsePanels").run {
            invoke(it)
        }
    }
} catch (localException: Exception) {
    localException.printStackTrace()
}

/**
 * 判断相应包名的apk是否存在

 * @param context     Context
 * *
 * @param packageName 包名
 * *
 * @return true存在
 */
fun isPkgInstalled(context: Context, packageName: String) = try {
    context.packageManager.getApplicationInfo(packageName, 0) != null
} catch (e: Exception) {
    false
}