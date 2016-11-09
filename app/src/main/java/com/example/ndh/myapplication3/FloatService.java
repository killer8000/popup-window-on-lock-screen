package com.example.ndh.myapplication3;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ndh on 16/11/8.
 */

public class FloatService extends Service {
    ScreenStateReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ndh--","onStartCommand");
                /* 注册屏幕唤醒时的广播 */
        IntentFilter intentenfilter = new IntentFilter();
        intentenfilter.addAction(Intent.ACTION_SCREEN_ON);
        intentenfilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentenfilter.addAction(Intent.ACTION_USER_PRESENT);
        receiver = new ScreenStateReceiver();
        registerReceiver(receiver, intentenfilter);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null!=receiver)
        unregisterReceiver(receiver);
    }
}
