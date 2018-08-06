package mycode.com.mycode;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * MyService
 * (c)2018 AIR Times Inc. All rights reserved.
 *
 * @author Lishp
 * @version 1.0
 * @date 2018/8/2 9:17
 * @see
 */
public class MyService extends Service{

    /**
     * 创建服务时调用
     */
    @Override
    public void onCreate() {
        Log.d("-------","onCreate");
        super.onCreate();
    }

    /**
     *  服务执行操作
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("-------", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 销毁服务时候调用的事件
     */
    @Override
    public void onDestroy() {
        Log.d("-------", "onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
