package com.example.administrator.spireofvalidus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

import com.example.administrator.spireofvalidus.util.BitmapUtils;

/**
 * Created by Administrator on 2017/7/6.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView{
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d != null) {
            int width = (int) ((((float) BitmapUtils.WIDTH)/100)*40);
           int height= (int) (((float)d.getIntrinsicHeight()/(float)d.getIntrinsicWidth())*width);
            Log.e("--imageWidth--","----"+width);
            Log.e("--imageHeight--","----"+height);
            setMeasuredDimension(width, height);

        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        }
    }
}
