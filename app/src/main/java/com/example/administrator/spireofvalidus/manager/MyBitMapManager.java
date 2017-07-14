package com.example.administrator.spireofvalidus.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.example.administrator.spireofvalidus.R;
import com.example.administrator.spireofvalidus.drawimgarr.DrawImgArr;
import com.example.administrator.spireofvalidus.util.BitmapUtils;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MyBitMapManager extends View {
    private static Bitmap bitmapHC = null;	//缓冲图
    private static Bitmap bitmapMyPlayer = null;    //角色图
    private static Bitmap bitmapEnemy = null;    //怪物
    private static Bitmap bitmapCombatBg = null;    //战斗视图背景图
    private static Bitmap bitmapWinImg = null;    //战斗胜利图
    private static Bitmap bitmapLoseImg = null;    //战斗失败图
    private static Bitmap bitmapArticleBg = null;	//消息视图背景
    private static Bitmap bitmapDoor = null;	//门
    private static Bitmap bitmapImgall = null;	//大图、背景
    private static Bitmap bitmapMtfontimg = null;	//键盘下背景
    private static Bitmap bitmapArticle = null;	//物品图
    private static Bitmap bitmapNpcImg = null;	//NPC
    private static Bitmap bitmapShopimgbg = null;	//NPC
    public MyBitMapManager(Context context) {
        super(context);
    }
    public void initBitMap() {
        if (bitmapHC == null || bitmapImgall == null || bitmapLoseImg == null) {
            bitmapNpcImg= ((BitmapDrawable) getResources().getDrawable(R.drawable.npcimg)).getBitmap();
            bitmapHC = Bitmap.createBitmap(BitmapUtils.WIDTH, BitmapUtils.HEIGHT, Bitmap.Config.ARGB_8888);
            bitmapArticle = ((BitmapDrawable) getResources().getDrawable(R.drawable.wupin)).getBitmap();
            bitmapMtfontimg = ((BitmapDrawable) getResources().getDrawable(R.drawable.mtfontimg)).getBitmap();
            bitmapImgall = ((BitmapDrawable) getResources().getDrawable(R.drawable.imgall)).getBitmap();
            bitmapMyPlayer = ((BitmapDrawable) getResources().getDrawable(R.drawable.myactor)).getBitmap();
            bitmapEnemy = ((BitmapDrawable) getResources().getDrawable(R.drawable.enemy)).getBitmap();
            bitmapCombatBg = ((BitmapDrawable) getResources().getDrawable(R.drawable.zhandoubg)).getBitmap();
            bitmapWinImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.winimg)).getBitmap();
            bitmapLoseImg = ((BitmapDrawable) getResources().getDrawable(R.drawable.shibaiimg)).getBitmap();
            bitmapArticleBg = ((BitmapDrawable) getResources().getDrawable(R.drawable.wupinbg)).getBitmap();
            bitmapDoor = ((BitmapDrawable) getResources().getDrawable(R.drawable.door)).getBitmap();
            drawImgArr();
        }
    }

    private void drawImgArr() {
        DrawImgArr.acx001=(bitmapMyPlayer.getWidth()/3)*7;
        DrawImgArr.acxx001=(bitmapMyPlayer.getWidth()/3)*7;
        DrawImgArr.acy001=(bitmapMyPlayer.getHeight()/4)*17;
        DrawImgArr.acxy001=(bitmapMyPlayer.getHeight()/4)*2;
        DrawImgArr.acx002=(bitmapMyPlayer.getWidth()/3)*3;
        DrawImgArr.acxx002=(bitmapMyPlayer.getWidth()/3)*3;
        DrawImgArr.acy002=(bitmapMyPlayer.getHeight()/4)*17;
        DrawImgArr.acxy002=(bitmapMyPlayer.getHeight()/4)*2;
        DrawImgArr.acx003=(bitmapMyPlayer.getWidth()/3);
        DrawImgArr.acxx003=(bitmapMyPlayer.getWidth()/3)*11;
        DrawImgArr.acy003=(bitmapMyPlayer.getHeight()/4)*3;
        DrawImgArr.acxy003=(bitmapMyPlayer.getHeight()/4)*9;
        DrawImgArr.acx004=(bitmapMyPlayer.getWidth()/3)*2;
        DrawImgArr.acxx004=(bitmapMyPlayer.getWidth()/3)*12;
        DrawImgArr.acy004=(bitmapMyPlayer.getHeight()/4)*16;
        DrawImgArr.acxy004=(bitmapMyPlayer.getHeight()/4)*17;
        DrawImgArr.acx005=(bitmapMyPlayer.getWidth()/3)*13;
        DrawImgArr.acxx005=(bitmapMyPlayer.getWidth()/3);
        DrawImgArr.acy005=(bitmapMyPlayer.getHeight()/4)*17;
        DrawImgArr.acxy005=(bitmapMyPlayer.getHeight()/4)*17;
        DrawImgArr.acx006=(bitmapMyPlayer.getWidth()/3)*13;
        DrawImgArr.acy006=(bitmapMyPlayer.getHeight()/4)*16;

    }

    /**
     * 角色图
     */
    public static Bitmap getBitmapMyactor() {
        return bitmapMyPlayer;
    }

    /**
     * 怪物
     */
    public static Bitmap getBitmapEnemy() {
        return bitmapEnemy;
    }
    /**战斗视图背景图*/
    public static Bitmap getBitmapCombatBg() {
        return bitmapCombatBg;
    }

    /**
     * 战斗胜利图
     */
    public static Bitmap getBitmapWinImg() {
        return bitmapWinImg;
    }

    /**
     * 战斗失败图
     */
    public static Bitmap getBitmapLoseImg() {
        return bitmapLoseImg;
    }
    /**消息视图背景*/
    public static Bitmap getBitmapArticleBg() {
        return bitmapArticleBg;
    }
    /**门*/
    public static Bitmap getBitmapDoor() {
        return bitmapDoor;
    }
    /**大图、背景*/
    public static Bitmap getBitmapImgall() {
        return bitmapImgall;
    }
    /**键盘下背景*/
    public static Bitmap getBitmapMtfontimg() {
        return bitmapMtfontimg;
    }
    /**物品图*/
    public static Bitmap getBitmapArticle() {
        return bitmapArticle;
    }
    /**缓冲图*/
    public static Bitmap getBitmapHC() {
        return bitmapHC;
    }
    /**NPC图*/
    public static Bitmap getBitmapNpcImg() {
        return bitmapNpcImg;
    }
}
