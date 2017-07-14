package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;


public class DrawGuaiWuImage extends View implements Runnable {
	public static final int COLNUM=4;
//	public static final int W=32;
//	public static final int H=32;
	int currentIndex;
	int [][] guaiwuImageArr=null;
	Bitmap bitmap=null;
	public DrawGuaiWuImage(Context context) {
		super(context);
		bitmap= MyBitMapManager.getBitmapEnemy();
		guaiwuImageArr= ImgArrManager.monsterImgArr;
		new Thread(this).start();
	}
	
	public void drawGuaiWu(Canvas canvas){
		if(guaiwuImageArr!=null){
		for (int row = 0; row < guaiwuImageArr.length; row++) {
			for (int column = 0; column < guaiwuImageArr[row].length; column++) {

				int imgIndex = guaiwuImageArr[row][column];
				if(imgIndex!=0){
				int sy= imgIndex/COLNUM;
				drawImg(canvas,bitmap,column*(bitmap.getWidth()/4),row*(bitmap.getWidth()/4),currentIndex*(bitmap.getWidth()/4),sy*(bitmap.getWidth()/4),(bitmap.getWidth()/4),(bitmap.getWidth()/4));
				}
			}
		}
		}
	}
	public void drawImg(Canvas canvas, Bitmap image, int x, int y, int sx, int sy, int w , int h){
		Rect src =new Rect();
		src.left=sx;
		src.right=sx+w;
		src.top=sy;
		src.bottom=sy+h;
		Rect dst =new Rect();
		dst.left=x;
		dst.right=x+w;
		dst.top=y;
		dst.bottom=y+h;
		canvas.drawBitmap(image, src, dst, null);
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(200);
				currentIndex++;
				if(currentIndex==4){
					currentIndex=0;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}
		
	}

}
