package com.fl.Home.util;

/**
 * Created by fl on 2017/3/7.
 */


import android.content.Context;
import android.view.Display;
import android.view.WindowManager;


public class SystemUtil {


    public static int getSystemWidth(Context context) {

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int width = display.getWidth();

        return width;
    }

    public static int getSystemHeight(Context context) {

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int height = display.getHeight();
        return height;
    }

}
