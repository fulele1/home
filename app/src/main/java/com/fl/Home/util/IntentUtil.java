package com.fl.Home.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by fl on 2017/6/13.
 */

public class IntentUtil {
    public static void start(Context context, Class<?> cla) {
        Intent mIntent = new Intent(context, cla);
        context.startActivity(mIntent);
    }

    public static void start(Context context, Class<?> cla,String s) {
        Intent mIntent = new Intent(context, cla);
        context.startActivity(mIntent);
    }
}
