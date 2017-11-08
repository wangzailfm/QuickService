package top.jowanxu.evernotequicksetting.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.DataOutputStream;

/**
 * @author Jowan
 */
public class Utils {

    /**
     * 获取root权限
     *
     * @param pkgCodePath pkgCodePath
     * @return boolean
     */
    public static boolean upgradeRootPermission(String pkgCodePath) {
        Process process = null;
        DataOutputStream os = null;
        try {
            String cmd = "chmod 777 " + pkgCodePath;
            //切换到root帐号
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * adb启动activity
     *
     * @param context         Context
     * @param pkgName         包名
     * @param pkgActivityName 启动的activity
     */
    public static void startActivity(Context context, String pkgName, String pkgActivityName) {
        Process process = null;
        DataOutputStream os = null;
        try {
            String cmd = "am start -n " + pkgName + "/" + pkgActivityName;
            //切换到root帐号
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            Toast.makeText(context, "启动Activity失败" + e.toString(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断相应包名的apk是否存在
     *
     * @param context     Context
     * @param packageName 包名
     * @return true存在
     */
    public static boolean isPkgInstalled(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        android.content.pm.ApplicationInfo info;
        try {
            info = context.getPackageManager().getApplicationInfo(packageName, 0);
            return info != null;
        } catch (Exception e) {
            return false;
        }
    }
}
