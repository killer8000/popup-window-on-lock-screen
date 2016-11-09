package com.example.ndh.myapplication3;

import android.content.Context;
import android.os.PowerManager;

/**
 * Created by ndh on 16/11/9.
 */

public class ScreenStateManager {
    static int screenState=0;// 0 用户解锁 1 亮屏 -1 锁屏

    //判断当时屏幕是否处于打开状态
    public boolean isScreenOn(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm.isScreenOn()) {
            return true;
        }
        return false;
    }
}
