package com.example.ndh.myapplication3;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON

        );
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(new DialogListAdapter(MainActivity.this));
//        listView.setAlpha((float)0.2);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        LinearLayout layout = (LinearLayout) findViewById(R.id.list_container);
        layout.setPadding(metrics.widthPixels/20,metrics.heightPixels/4,metrics.widthPixels/20,0);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

//    private void createDialog() {
//        View view = View.inflate(MainActivity.this, R.layout.layout_dialog, null);
//        WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
//        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;// 系统提示window
//        mParams.format = PixelFormat.TRANSLUCENT;// 支持透明
////        mParams.format = PixelFormat.RGBA_8888;
////        mParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// 焦点
//        mParams.width = getResources().getDisplayMetrics().widthPixels / 2;//窗口的宽和高
//        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        mParams.gravity = Gravity.CENTER;
//        mParams.x = mParams.width;//窗口位置的偏移量
//        mParams.y = mParams.height / 2;
////        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//        getWindow().addContentView(view, mParams);
//        Button bt = (Button) view.findViewById(R.id.bt);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }

//    public void createFloatView() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (Build.VERSION.SDK_INT >= 23) {
//                    if (Settings.canDrawOverlays(MainActivity.this)) {
//
//                    } else {
//                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                        startActivity(intent);
//                        return;
//                    }
//                }
//                final View floatview = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_dialog, null);
//                mearsureView(floatview);
//                // windowManager =getWindowManager();
//                // Log.v("TAG","-----activity windowManager---"+ windowManager);
//                final WindowManager floatWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//                Log.v("TAG", "----floatWindowManager is---" + floatWindowManager);
//                Display display = floatWindowManager.getDefaultDisplay();
//                int width = display.getWidth();
//                int height = display.getHeight();
//                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
////                layoutParams.type= WindowManager.LayoutParams.TYPE_PHONE;
////        layoutParams.flags= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|
////                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
////        layoutParams.flags=WindowManager.LayoutParams.MATCH_PARENT;
//                layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
//                layoutParams.x = width / 2 - floatview.getMeasuredWidth() / 2;
//                layoutParams.y = height / 2 - floatview.getMeasuredHeight() / 2;
//                layoutParams.width = floatview.getMeasuredWidth();
//                layoutParams.height = floatview.getMeasuredHeight();
////                getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
//                floatWindowManager.addView(floatview, layoutParams);
//                Button bt = (Button) floatview.findViewById(R.id.bt);
//                bt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                        floatWindowManager.removeView(floatview);
//                    }
//                });
//            }
//        });
//
//
//    }

    public void mearsureView(View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (true) {
            final View view = getWindow().getDecorView();
            final WindowManager.LayoutParams lp = (WindowManager.LayoutParams) view.getLayoutParams();
            lp.gravity = Gravity.CENTER;
//            lp.width = getResources().getDisplayMetrics().widthPixels / 2;
//            lp.height = getResources().getDisplayMetrics().heightPixels / 3;
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(new BitmapDrawable(getWallPaper()));
            } else {
                view.setBackgroundColor(Color.WHITE);
            }
            getWindowManager().updateViewLayout(view, lp);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public Bitmap getWallPaper() {
        WallpaperManager wallpaperManager = WallpaperManager
                .getInstance(MainActivity.this);
        // 获取当前壁纸
        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        Bitmap bm = ((BitmapDrawable) wallpaperDrawable).getBitmap();

        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int with = bm.getHeight()*widthPixels/heightPixels > bm.getWidth() ? bm.getWidth():bm.getHeight()*widthPixels/heightPixels;
        Bitmap pbm = Bitmap.createBitmap(bm, 0, 0, with, bm.getHeight());
        // 设置 背景
        return pbm;
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

}
