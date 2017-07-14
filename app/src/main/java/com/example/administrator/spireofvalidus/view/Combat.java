package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.administrator.spireofvalidus.entity.Monster;
import com.example.administrator.spireofvalidus.entity.Player;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Combat extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    private SurfaceHolder surfaceHolder;
    private Thread thread;
    private boolean flag;
    Player player=null;
    public Monster monster=null;
    Paint paint=null;
    Bitmap bitmapBg=null;
    Bitmap winBitmap=null;
    Bitmap loseBitmap=null;
    public Handler handler=null;
    //窗口透明度
//    int alpha=0;
    //战斗状态  0 出现战斗窗口  1 开始战斗  20 渐隐战斗绘图，渐出胜利结果窗口，21 处理胜利结果
    // 30 渐隐战斗绘图，渐出失败结果窗口  31处理失败结果   4 从Handler中移除此战斗Run
    public	int visiIndex=4;
    //记录玩家战斗前血量
    int playerHp=0;
    //用于战斗，如果为true玩家攻击，false，怪物攻击
    boolean combat=true;
    public Combat(Context context) {
        super(context);
    }

    public Combat(Context context, AttributeSet attrs) {
        super(context, attrs);
        player=Player.getPlayer(context);
        bitmapBg= MyBitMapManager.getBitmapCombatBg();
        winBitmap=MyBitMapManager.getBitmapWinImg();
        loseBitmap=MyBitMapManager.getBitmapLoseImg();
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(100);
        thread=new Thread( this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {
        Canvas canvas=null;
        while (!flag){
            synchronized (surfaceHolder){

                try {
                    canvas=surfaceHolder.lockCanvas();
                    render(canvas);
                    combat();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if (canvas!=null){
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }

                }
            }
        }
    }

    private void render(Canvas canvas) {
        canvas.drawBitmap(bitmapBg, 0, 0, paint);
        player.drawPlayer(canvas,350,80,64,64);
        monster.drawMonster(canvas,60,75,64,64);
        paint.setColor(Color.WHITE);
        paint.setTextSize(16);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        //绘制血量
        canvas.drawText(player.getHp()+"",265,90,paint);
        canvas.drawText(monster.getHp()+"",170,90,paint);
        //绘制攻击力
        canvas.drawText(player.getAtk()+"",265,115,paint);
        canvas.drawText(monster.getAtk()+"",170,115,paint);
        //绘制防御值
        canvas.drawText(player.getDef()+"",265,140,paint);
        canvas.drawText(monster.getDef()+"",170,140,paint);
        //绘制名字
        canvas.drawText(player.getName(),350,200,paint);
        canvas.drawText(monster.getName(),50,200,paint);
    }
    private void combat() {
        int playerHp=player.getHp();
        int monsterHp=monster.getHp();
        if (this.combat){
            int playerHarm=player.getAtk()-monster.getDef();
            if (playerHarm>0){
                if (monsterHp-playerHarm<=0){
                    visiIndex=20;
//                    alpha=270;
                    return;
                }
                monster.setHp(monsterHp-playerHarm);
            }
            this.combat=false;
        }else {
            int monsterHarm=monster.getAtk()-player.getDef();
            if (monsterHarm>0){
                if (playerHp-monsterHarm<=0){
                    visiIndex=30;
                    return;
                }
                player.setHp(playerHp-monsterHarm);
            }
            this.combat=true;
        }
    }
}
