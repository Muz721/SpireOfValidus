package com.example.administrator.spireofvalidus.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.administrator.spireofvalidus.manager.MyBitMapManager;

import java.util.HashMap;
import java.util.Map;

//import android.view.View;

/**
 * Created by Administrator on 2017/7/10.
 */

public class Player extends View implements Runnable{
    private String name="勇士";     //名字
    private int level=1;          //等级
    private int hp=1000;         //血量
    private int atk=50;          //攻击力
    private int def=10;         //防御值
    private int MyX;             //位置x坐标
    private int MyY;              //位置y坐标
    private int goldKey=1;      //金钥匙
    private int silverKey=1;    //银钥匙
    private int copperKey=1;    //铜钥匙
    private int money=200;      //初始金币
    private int exp=100;        //拥有经验
    private int fx;             //人物面对方向
    private int currdz;          //动作
    private Bitmap playerMap=null; //人物图像
    private int mtStorey=3;            //人物在第几层
    private int mtStoreyMax=1;         //人物最大到层数
    public static boolean loutiFlag=false;//false 向上走	true 下来 (坐标)
    //特殊物品 	K=物品名称 ，V 用于检测判断
    public Map<String,String> tsWpMap=new HashMap<String,String>();
    private Player(Context context){
        super(context);
        playerMap= MyBitMapManager.getBitmapMyactor();
        new Thread(this).start();
    }
private static Player player=null;
    public static Player getPlayer(Context context){
        if (player==null){
            player=new Player(context);
        }
        return player;
    }
    public void drawPlayer(Canvas canvas){
//        Log.e("-x-x---",playerMap.getWidth()+"");
//        Log.e("-x-y---",playerMap.getHeight()+"");
        Rect src=new Rect();
        src.left=currdz*(playerMap.getHeight()/4);
        src.top=fx*(playerMap.getHeight()/4);
        src.right=currdz*(playerMap.getHeight()/4)+(playerMap.getHeight()/4);
        src.bottom=fx*(playerMap.getHeight()/4)+(playerMap.getHeight()/4);
        Rect dst =new Rect();
        dst.left=MyX;
        dst.top=MyY;
        dst.right=MyX+(playerMap.getHeight()/4);
        dst.bottom=MyY+(playerMap.getHeight()/4);
        canvas.drawBitmap(playerMap, src, dst, null);
    }
    public  void drawPlayer(Canvas canvas,int left,int top,int w ,int h){
        fx=0;
        Rect src=new Rect();
        src.left=currdz*(playerMap.getHeight()/4);
        src.top=fx*(playerMap.getHeight()/4);
        src.right=currdz*(playerMap.getHeight()/4)+(playerMap.getHeight()/4);
        src.bottom=fx*(playerMap.getHeight()/4)+(playerMap.getHeight()/4);
        Rect dst =new Rect();
        dst.left=left;
        dst.top=top;
        dst.right=left+w;
        dst.bottom=top+h;
        canvas.drawBitmap(playerMap, src, dst, null);
    }
    //升级方法
    public String addLevel(int addValue,int subExp){
        if(subExp>0){
            if(this.exp-subExp<0){
                return " 经验值不够！";
            }else{
                this.exp-=subExp;
            }
        }
        if(addValue>0){
            this.level+=addValue;
            this.atk+=addValue*4;
            this.def+=addValue*4;
            this.hp+=addValue*800;
        }
        return "恭喜你升了 "+addValue+" 级 !";
    }
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(300);
                currdz++;
                if(currdz>2){
                    currdz=0;
                }
            }catch (Exception ignored) {
            }

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int gjValue) {
        this.atk = gjValue;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int fyValue) {
        this.def = fyValue;
    }


    public int getCopperKey() {
        return copperKey;
    }

    public void setCopperKey(int copperKey) {
        this.copperKey =copperKey;
    }

    public int getGoldKey() {
        return goldKey;
    }

    public void setGoldKey(int goldKey) {
        this.goldKey = goldKey;
    }

    public int getSilverKey() {
        return silverKey;
    }

    public void setSilverKey(int silverKey) {
        this.silverKey = silverKey;
    }

    public int getFx() {
        return fx;
    }

    public void setFx(int fx) {
        this.fx = fx;
    }

    public int getCurrdz() {
        return currdz;
    }

    public void setCurrdz(int currdz) {
        this.currdz = currdz;
    }

    public Bitmap getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Bitmap playerMap) {
        this.playerMap = playerMap;
    }

    public int getMtStorey() {
        return mtStorey;
    }

    public void setMtStorey(int mtStorey) {
        this.mtStorey = mtStorey;
        if(this.mtStorey>this.mtStoreyMax){
            this.mtStoreyMax=this.mtStorey;
        }
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setmtStoreyMax(int mtStoreyMax) {
        this.mtStoreyMax = mtStoreyMax;
    }

    public int getmtStoreyMax() {
        return mtStoreyMax;
    }

    public int getMyX() {
        return MyX;
    }

    public void setMyX(int myX) {
        MyX = myX;
    }

    public int getMyY() {
        return MyY;
    }

    public void setMyY(int myY) {
        MyY = myY;
    }
}
