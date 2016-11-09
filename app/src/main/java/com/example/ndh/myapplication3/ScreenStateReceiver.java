package com.example.ndh.myapplication3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ndh on 16/11/8.
 */

public class ScreenStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("ndh--", "action=" + action);
        if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏
            ScreenStateManager.screenState=1;
            Log.d("ndh--", "screen on");
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
            ScreenStateManager.screenState=-1;
            Log.d("ndh--", "screen off");
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // 解锁
            ScreenStateManager.screenState=0;
            Log.d("ndh--", "user_present");
        }
    }
}
