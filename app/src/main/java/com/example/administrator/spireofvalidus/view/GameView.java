package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.administrator.spireofvalidus.entity.Npc;
import com.example.administrator.spireofvalidus.entity.Player;
import com.example.administrator.spireofvalidus.main.GameActivity;
import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;
import com.example.administrator.spireofvalidus.util.BitmapUtils;

/**游戏界面*/
public class GameView extends View implements Runnable {
	private Bitmap bitmapBg = null;//背景和障碍物图
	private Bitmap bitmapWp=null;//物品(道具)图
	private Bitmap bitmapHcq=null;//背景和障碍物图
	private Canvas canvas=null;//临时绘制对象
	private Paint paint=null;//创建一个画笔对象
	boolean bgPaint=true;//是否重新绘制背景(一般背景障碍物等只绘制一次。)
	Player player=null;//玩家
	Npc npc=null;
	Bitmap mtTextImgbg=null;//按键下面的背景图片
	DrawGuaiWuImage guaiWuImage=null;//绘制全体(动)怪物
	DrawDoorImage drawDoor=null;////绘制门
	public GameView(Context context) {
		super(context);
	}
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmapBg = MyBitMapManager.getBitmapImgall();
		mtTextImgbg=MyBitMapManager.getBitmapMtfontimg();
		bitmapWp=MyBitMapManager.getBitmapArticle();
		bitmapHcq=MyBitMapManager.getBitmapHC();
		canvas=new Canvas();
		canvas.setBitmap(bitmapHcq);
		paint=new Paint();
		canvas.drawRect(0, 0, BitmapUtils.WIDTH, BitmapUtils.HEIGHT, paint);
		player=Player.getPlayer(context);
		npc=Npc.getNpc();
		guaiWuImage=new DrawGuaiWuImage(context);
		drawDoor=new DrawDoorImage(context);
		new Thread(this).start();
		Log.e("--背景x---",bitmapBg.getWidth()+"");
		Log.e("--背景y---",bitmapBg.getHeight()+"");
		}
	@Override
	protected void onDraw(Canvas canvas) {
		if(bgPaint){
//绘制背景
			drawImageByArr(this.canvas, bitmapBg, ImgArrManager.bgImgArr,bitmapBg.getWidth()/24,bitmapBg.getHeight()/16,24);
			//绘制一个  半透明(全屏) 的黑色图 覆盖背景
			paint.setAlpha(50);
			paint.setStyle(Style.FILL);
			this.canvas.drawRect(0, 0,  BitmapUtils.WIDTH, BitmapUtils.HEIGHT, paint);
			this.canvas.drawBitmap(mtTextImgbg, 0,BitmapUtils.HEIGHT-200, paint);
			//绘制bg2图
			drawImageByArr(this.canvas, bitmapBg, ImgArrManager.bg2ImgArr,bitmapBg.getWidth()/24,bitmapBg.getHeight()/16,24);
			//绘制障碍物图
			drawImageByArr(this.canvas, bitmapBg, ImgArrManager.barrierImgArr,bitmapBg.getWidth()/24,bitmapBg.getHeight()/16,24);
			//绘制楼梯
			drawImageByArr(this.canvas, bitmapBg, ImgArrManager.stairwayImgArr, bitmapBg.getWidth()/24,bitmapBg.getHeight()/16, 24);
			bgPaint=false;
			GameActivity.keyFlag=true;
		}
		canvas.drawBitmap(bitmapHcq, 0, 0, null);

//		player.drawPlayer(canvas);
		guaiWuImage.drawGuaiWu(canvas);
		drawDoor.drawDoor(canvas);
		npc.drawNpc(canvas);

		player.drawPlayer(canvas);
		//绘制物品
		drawImageByArr(canvas, bitmapWp, ImgArrManager.articleImgArr,bitmapWp.getWidth()/4,bitmapWp.getWidth()/4,4);
	}
	public void drawImageByArr(Canvas canvas, Bitmap image, int[][] arrImg, float width, float height, int rowSize) {
		if(arrImg!=null){
			for (int row = 0; row < arrImg.length; row++) {
				for (int column = 0; column < arrImg[row].length; column++) {
					// 绘制图像
					int imgIndex = arrImg[row][column];
					if(imgIndex!=0){
						//获得本整形元素在图片上的行/列
					int srow= imgIndex/rowSize;
					int scolumn= imgIndex%rowSize;
					drawImg(canvas,image,column*width,row*height,scolumn*width,srow*height,width ,height);
					}
				}
			}
		}
	}
	
	public void drawImg(Canvas canvas, Bitmap image, float x, float y, float sx, float sy, float w , float h){
		Rect src =new Rect();
		src.left= (int) sx;
		src.right= (int) (sx+w);
		src.top= (int) sy;
		src.bottom= (int) (sy+h);
		RectF dst =new RectF();
		dst.left=  x;
		dst.right=x+w;
		dst.top=  y;
		dst.bottom= y+h;
		canvas.drawBitmap(image, src, dst, null);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}
	}

}
