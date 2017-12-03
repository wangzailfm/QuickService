package top.jowanxu.evernotequicksetting.utils

import android.content.Context
import android.widget.Toast

import java.io.DataOutputStream

/**
 * @author Jowan
 */
object Utils {

    /**
     * 获取root权限

     * @param pkgCodePath pkgCodePath
     * *
     * @return boolean
     */
    fun upgradeRootPermission(pkgCodePath: String): Boolean {
        var process: Process? = null
        var os: DataOutputStream? = null
        try {
            val cmd = "chmod 777 " + pkgCodePath
            //切换到root帐号
            process = Runtime.getRuntime().exec("su")
            os = DataOutputStream(process!!.outputStream)
            os.writeBytes(cmd + "\n")
            os.writeBytes("exit\n")
            os.flush()
            process.waitFor()
        } catch (e: Exception) {
            return false
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
}
