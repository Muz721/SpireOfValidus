package com.example.administrator.spireofvalidus.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;

/**
 * Created by Administrator on 2017/7/10.
 */

public class Npc implements Runnable{
    Bitmap bitmap=null;
    static int [][] npcImgArr=null;
    int currentIndex;
    private Npc(){
        bitmap= MyBitMapManager.getBitmapNpcImg();
        new Thread(this).start();
    }
private static Npc npc=null;
    public static Npc getNpc(){
        if (npc==null){
            npc=new Npc();
        }
        npcImgArr= ImgArrManager.npcImgArr;
        return npc;
    }
    public void drawNpc(Canvas canvas){
        Log.e("--npc-x-x--","-----"+bitmap.getWidth());
        Log.e("-x-npc--y--","-----"+bitmap.getHeight());
        if (npcImgArr!=null){
            for (int i = 0; i <npcImgArr.length ; i++) {
                for (int j = 0; j <npcImgArr[i].length ; j++) {
                    int imgIndex=npcImgArr[i][j];
                    if (imgIndex!=0){
                        int sy=imgIndex/3;
                        drawImg(canvas,bitmap,j*(bitmap.getWidth()/3),i*(bitmap.getWidth()/3),currentIndex*(bitmap.getWidth()/3),sy*(bitmap.getWidth()/3),(bitmap.getWidth()/3),(bitmap.getWidth()/3));
                    }
                }
            }
        }
    }

    private void drawImg(Canvas canvas, Bitmap bitmap, int x, int y, int sx, int sy,int w, int h) {
        Rect src=new Rect();
        src.left=sx;
        src.right=sx+w;
        src.top=sy;
        src.bottom=sy+h;
        Rect dst=new Rect();
        dst.left=x;
        dst.right=x+w;
        dst.top=y;
        dst.bottom=y+h;
        canvas.drawBitmap(bitmap,src,dst,null);
    }
    public void drawImg(Canvas canvas,int x,int y,int sx,int sy,int w ,int h){
        Rect src =new Rect();
        src.left=sx;
        src.right=sx+(bitmap.getWidth()/3);
        src.top=sy;
        src.bottom=sy+(bitmap.getWidth()/3);
        Rect dst =new Rect();
        dst.left=x;
        dst.right=x+w;
        dst.top=y;
        dst.bottom=y+h;
        canvas.drawBitmap(bitmap, src, dst, null);
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try{
                Thread.sleep(300);
                currentIndex++;
                if (currentIndex==3){
                    currentIndex=0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
