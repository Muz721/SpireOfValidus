package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.administrator.spireofvalidus.entity.Monster;
import com.example.administrator.spireofvalidus.entity.Player;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;
import com.example.administrator.spireofvalidus.util.BitmapUtils;
import com.example.administrator.spireofvalidus.util.DataSynEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/7/10.
 */

public class CombatView  extends View {
    Player player=null;
    public Monster monster=null;
    Paint paint=null;
    Bitmap bitmapBg=null;
    Bitmap winBitmap=null;
    Bitmap loseBitmap=null;
    public Handler handler=null;
    //窗口透明度
    int alpha=0;
    //战斗状态  0 出现战斗窗口  1 开始战斗  20 渐隐战斗绘图，渐出胜利结果窗口，21 处理胜利结果
    // 30 渐隐战斗绘图，渐出失败结果窗口  31处理失败结果   4 从Handler中移除此战斗Run
    public	int visiIndex=4;
    //记录玩家战斗前血量
    int playerHp=0;
    //用于战斗，如果为true玩家攻击，false，怪物攻击
    boolean combat=true;
    public CombatView(Context context) {
        super(context);
    }

    public CombatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        player=Player.getPlayer(context);
        paint=new Paint();
        bitmapBg= MyBitMapManager.getBitmapCombatBg();
        winBitmap=MyBitMapManager.getBitmapWinImg();
        loseBitmap=MyBitMapManager.getBitmapLoseImg();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (visiIndex==0){
            alpha+=30;
            paint.setAlpha(alpha);
            canvas.drawBitmap(bitmapBg, 0, 0, paint);
            visiIndex=alpha>200?1:0;
            if(alpha>200){
                drawplayerAndMonsterInfo(canvas);
//                move();
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);
            }
        }else if (visiIndex==1){
            canvas.drawBitmap(bitmapBg,0,0,null);
            drawplayerAndMonsterInfo(canvas);
        }else if (visiIndex==20){
            //渐隐战斗绘图，渐出胜利结果窗口
            alpha-=30;
            paint.setAlpha(alpha);
            canvas.drawBitmap(bitmapBg, 0, 0, paint);
            paint.setAlpha(255-alpha);
            canvas.drawBitmap(winBitmap, 0, 50, paint);
            if(alpha<120){
                drawWinInfo(canvas);
            }
            if (alpha<30){
                handler.removeCallbacks(runnable);
                visiIndex=21;
                handler.postDelayed(runnable, 1500);
//                move();
            }
        }else if (visiIndex==21){
            canvas.drawBitmap(winBitmap,0,50,null);
            drawWinInfo(canvas);
        }else if (visiIndex==30){
            //渐隐战斗绘图，渐出失败结果窗口
            alpha-=30;
            paint.setAlpha(alpha);
            canvas.drawBitmap(bitmapBg, 0, 0, paint);
            paint.setAlpha(255-alpha);
            canvas.drawBitmap(loseBitmap, 0, 50, paint);
            if (alpha<30){
                handler.removeCallbacks(runnable);
                visiIndex=31;
//                move();
                handler.postDelayed(runnable, 2500);
            }
        }else if (visiIndex==31){
            canvas.drawBitmap(loseBitmap,0,50,null);
        }
    }


    private void drawWinInfo(Canvas canvas) {
        paint.setTextSize(28);
        canvas.drawText(monster.getMoney()+"",322,125,paint);
        canvas.drawText(monster.getExp()+"",322,195,paint);
    }

    private void drawplayerAndMonsterInfo(Canvas canvas) {

//        //绘制头像
//        player.drawPlayer(canvas,350,80,64,64);
        monster.drawMonster(canvas,60,75,64,64);
//        paint.setColor(Color.WHITE);
//        paint.setTextSize(16);
//        paint.setTypeface(Typeface.DEFAULT_BOLD);
//        //绘制血量
//        canvas.drawText(player.getHp()+"",265,90,paint);
//        canvas.drawText(monster.getHp()+"",170,90,paint);
//        //绘制攻击力
//        canvas.drawText(player.getAtk()+"",265,115,paint);
//        canvas.drawText(monster.getAtk()+"",170,115,paint);
//        //绘制防御值
//        canvas.drawText(player.getDef()+"",265,140,paint);
//        canvas.drawText(monster.getDef()+"",170,140,paint);
//        //绘制名字
//        canvas.drawText(player.getName(),350,200,paint);
//        canvas.drawText(monster.getName(),50,200,paint);
        Log.e("-----left-","-----"+(BitmapUtils.HEIGHT/100)*70);
        Log.e("-----top-","-----"+(BitmapUtils.HEIGHT/100)*9);
        Log.e("-----w-","-----"+(player.getPlayerMap().getWidth()/3)*2);
        Log.e("-----h-","-----"+(player.getPlayerMap().getWidth()/3)*2);

        player.drawPlayer(canvas,(BitmapUtils.WIDTH/100)*70,(BitmapUtils.HEIGHT/100)*9,(player.getPlayerMap().getWidth()/3)*2,(player.getPlayerMap().getWidth()/3)*2);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView,int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility==View.VISIBLE){
            if(this.handler==null){
                return;
            }
          if (this.getVisibility()==VISIBLE){
              visiIndex=0;
          }
//          move();
            this.handler.post(runnable);
            this.alpha=0;
            this.playerHp=player.getHp();
        }else if (visibility==View.INVISIBLE){
            visiIndex=4;
        }
    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            try{
                if(visiIndex==0){
                    handler.postDelayed(runnable, 100);
//                    move();
                }else if(visiIndex==1){
                    combat();
                    handler.postDelayed(runnable, 200);
//                    move();
                }else if(visiIndex==20){
                    handler.postDelayed(runnable, 200);
//                    move();
                }else if(visiIndex==21){
                    handler.postDelayed(runnable, 200);
                    //处理胜利结果 	增加金币，经验 并将胜利结果发送给 activity
                    player.setMoney(player.getMoney()+monster.getMoney());
                    player.setExp(player.getExp()+monster.getExp());
//                    Message message=handler.obtainMessage();
//                    message.arg1=1;
//                    handler.sendMessage(message);
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    EventBus.getDefault().postSticky(new DataSynEvent("1",1));
                    System.out.println("将战斗胜利的结果发送给 activity   ........");
                    invisiblethis();
                }else if(visiIndex==30){
                    handler.postDelayed(runnable, 200);
                }else if(visiIndex==31){
                    handler.postDelayed(runnable, 500);
                    //处理失败结果 减少10%金币和经验 并将失败结果发送给 activity
                    player.setHp(playerHp);
                    player.setMoney(player.getMoney()-player.getMoney()/10);
                    player.setExp(player.getExp()-player.getExp()/10);
//                    Message message=handler.obtainMessage();
//                    message.arg1=2;
//                    handler.sendMessage(message);
//                    move();
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
                    EventBus.getDefault().postSticky(new DataSynEvent("2",2));
                    System.out.println("将战斗失败的结果发送给 activity   ........");
                    invisiblethis();
                }else	if(visiIndex==4){
                    handler.removeCallbacks(runnable);
//                    Log.e("战斗视图", "Handler已移除runnable。。。");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            postInvalidate();
        }
    };

    private void invisiblethis() {
        this.setVisibility(INVISIBLE);
    }

//    private void move() {
//
////            EventBus.getDefault().postSticky(new DataSynEvent("2",2));
//
//        }


    private void combat() {
        int playerHp=player.getHp();
        int monsterHp=monster.getHp();
        if (this.combat){
            int playerHarm=player.getAtk()-monster.getDef();
            if (playerHarm>0){
                if (monsterHp-playerHarm<=0){
                    visiIndex=20;
                    alpha=270;
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
        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
    }
}
