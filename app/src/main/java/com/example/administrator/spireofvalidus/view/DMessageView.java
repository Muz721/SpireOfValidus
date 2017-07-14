package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.administrator.spireofvalidus.manager.MyBitMapManager;
import com.example.administrator.spireofvalidus.util.BitmapUtils;
import com.example.administrator.spireofvalidus.util.DataSynEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DMessageView extends View {
    Bitmap bitmapBg;
    public Handler handler=null;
    Paint paint;
    private	String title;
    private String content;
    //窗口透明度
    int alpha=0;
    //短消息播放 状态
    public	int visiIndex=1;
    public DMessageView(Context context) {
        super(context);
    }

    public DMessageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmapBg= MyBitMapManager.getBitmapArticleBg();
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (visiIndex==0){
            alpha+=30;
            paint.setAlpha(alpha);
            canvas.drawBitmap(bitmapBg, 0, 0, paint);
            visiIndex=alpha>220?1:0;
            if(alpha>220){
                drawTextInfo(canvas);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 1500);
//               move();
            }
        }else if (visiIndex==1){
            canvas.drawBitmap(bitmapBg, 0, 0, null);
            drawTextInfo(canvas);
        }
    }

    private void drawTextInfo(Canvas canvas) {
        paint.setColor(Color.LTGRAY);
        if("".equals(this.content)){
            paint.setTextSize(32);
            canvas.drawText(title, BitmapUtils.WIDTH/10, 110, paint);
        }else{
            paint.setTextSize(32);
            canvas.drawText(title, 70, 80, paint);
            paint.setTextSize(24);
            canvas.drawText(content, 100, 130, paint);
        }
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.e("-------dm-------","-------"+visibility);
        if (visibility==View.VISIBLE){
            if (this.handler==null){
                return;
            }
          if (this.getVisibility()==VISIBLE){
          visiIndex=0;
          }
            this.handler.post(runnable);
//            move();
            this.alpha=0;
        }else if (visibility==View.INVISIBLE){
        }
    }

//    private void move() {
//        EventBus.getDefault().postSticky(new DataSynEvent("5",5));
//    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            try{
                if(visiIndex==0){
                    handler.postDelayed(runnable, 100);
                }else	if(visiIndex==1){
                    invisiblethis();
                    handler.removeCallbacks(runnable);
                    EventBus.getDefault().postSticky(new DataSynEvent("5",5));
//                    Message message=handler.obtainMessage();
//                    message.arg1=5;
//                    handler.sendMessage(message);
//                    Log.i("短消息视图", "Handler已移除runnable。。。");
                    Log.e("-------sssssss---","---------------");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            postInvalidate();
        }
    };
    public void invisiblethis(){
        Log.e("----------","---------------");
        this.setVisibility(INVISIBLE);
    }

    public Bitmap getBitmapBg() {
        return bitmapBg;
    }

    public void setBitmapBg(Bitmap bitmapBg) {
        this.bitmapBg = bitmapBg;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getVisiIndex() {
        return visiIndex;
    }

    public void setVisiIndex(int visiIndex) {
        this.visiIndex = visiIndex;
    }
}
