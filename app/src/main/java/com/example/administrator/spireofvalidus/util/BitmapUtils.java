package com.example.administrator.spireofvalidus.util;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;

/**
 * Created by Administrator on 2017/7/6.
 *
 */

public class BitmapUtils {
    public static int WIDTH=0;
    public static int HEIGHT=0;
    public static float SCALE_WIDTH=0;
    public static float SCALE_HEIGHT=0;
    public static float DISPLAYWIDTH=0;
    public static float DISPLAYHEIGHT=0;
    public static void init(Activity activity){
        Display display=activity.getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        WIDTH=point.x;
        HEIGHT=point.y;
        Log.e("--WIDTH--","----"+WIDTH);
        Log.e("--HEIGHT--","----"+HEIGHT);
    }
//    public static Bitmap resizeBitmap(Bitmap bitmap, int displayWidth, int displayHeight){
//        if (bitmap != null) {
//            int width=bitmap.getWidth();
//            int height=bitmap.getHeight();
//            float scaleWidth = ((float) displayWidth )/ width;
//            float scaleHeight = ((float) displayHeight )/ height;
//            SCALE_WIDTH = scaleWidth;
//            SCALE_HEIGHT = scaleHeight;
//            Matrix matrix = new Matrix();
//            matrix.postScale(scaleWidth, scaleHeight);
//            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
//        }
//        return null;
//    }

}
