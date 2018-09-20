package yswl.com.klibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import yswl.com.klibrary.base.BaseApplication;
import yswl.com.klibrary.manager.ActivityManager;

/**
 * Created by kangpAdministrator on 2017/6/7 0007.
 * Emial kangpeng@yunhetong.net
 */

public abstract class MApplication extends BaseApplication /*implements DebugSetting ,PathSetting*/{

    private Handler mGolbalHander;
    public Handler getGolbalHander() {
        if (mGolbalHander == null) {
            mGolbalHander = new Handler(Looper.getMainLooper());
        }
        return mGolbalHander;
    }

    public abstract boolean getDebugSetting();

    private static MApplication app;
    public static MApplication getApplication() {
        return app;
    }

    @Override
    public void onCreate() {
        MApplication.app = this;
        super.onCreate();
//        DebugSetting debug = this;

    }

    /**
     * 应用程序退出
     */
    public static void AppExit(Context context) {
        try {
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.finishAllActivity();
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            System.exit(0);
        }
    }


    public abstract String getBaseUrl_Https();

}
