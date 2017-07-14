package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.administrator.spireofvalidus.entity.Door;
import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;


public class DrawDoorImage extends View {
	public static final int COLNUM=4;
	public static final int W=32;
	public static final int H=32;
	int [][] menImageArr=null;
	Bitmap bitmap=null;
	Door door=null;
	public DrawDoorImage(Context context) {
		super(context);
		bitmap= MyBitMapManager.getBitmapDoor();
		menImageArr= ImgArrManager.doorImgArr;
		door=Door.getDoor(context);
	}
	
	public void drawDoor(Canvas canvas){
		if(menImageArr!=null){
		for (int row = 0; row < menImageArr.length; row++) {
			for (int column = 0; column < menImageArr[row].length; column++) {

				int imgIndex = menImageArr[row][column];
				if(imgIndex!=0){

					int sy= imgIndex/COLNUM;
					drawImg(canvas,bitmap,column*(bitmap.getHeight()/4),row*(bitmap.getHeight()/4),0,sy*(bitmap.getHeight()/4),(bitmap.getHeight()/4),(bitmap.getHeight()/4));
				}

				if(door.checkDraw){
					if(door.getDoorRow()==row&&door.getDoorCol()==column){
						drawImg(canvas,bitmap,column*(bitmap.getHeight()/4),row*(bitmap.getHeight()/4),door.getaction()*(bitmap.getHeight()/4),door.getKey()*(bitmap.getHeight()/4),(bitmap.getHeight()/4),(bitmap.getHeight()/4));
					}
				}
				
			}
		}}
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

}
