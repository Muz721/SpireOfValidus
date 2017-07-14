package com.example.administrator.spireofvalidus.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.administrator.spireofvalidus.manager.MyBitMapManager;

/**
 * Created by Administrator on 2017/7/11.
 */

public class Monster implements Runnable{
    private String name="泡泡";
    private  int hp;				//血量
    private  int atk;		//攻击值
    private  int def;		//防御值
    private  int money;		//杀死获得金币
    private  int exp;			//杀死获得经验
    private  int action;		//动作
    private Bitmap monsterMap=null; //怪物图像
    private int monsterIndex,monsterRow,monsterCol;//怪物所在二维数组
    private  int monsterImageIndex=0; //怪物位置
    public Monster(){
        monsterMap= MyBitMapManager.getBitmapEnemy();
        new Thread(this).start();
    }
public void initMonster(String name,int hp,int atk,int def,int money,int exp,int imgIndex){
    this.name=name;
    this.hp=hp;
    this.atk=atk;
    this.def=def;
    this.money=money;
    this.exp=exp;
    this.monsterImageIndex=imgIndex;
}
public void drawMonster(Canvas canvas,int left,int top,int w,int h){
    int fx=monsterImageIndex;
    Rect src=new Rect();
    src.left=action*32;
    src.top=fx*32;
    src.right=action*32+32;
    src.bottom=fx*32+32;
    Rect dst=new Rect();
    dst.left=left;
    dst.top=top;
    dst.right=left+w;
    dst.bottom=top+h;
    canvas.drawBitmap(monsterMap,src,dst,null);
}
public boolean removeMonster(int [][] monsterArr){
    if (monsterArr[monsterRow][monsterCol]==monsterIndex){
        monsterArr[monsterRow][monsterCol]=0;
        return true;
    }else {
        return false;
    }
}
public void setMonsterArrInfo(int index,int row,int col){
    this.monsterIndex=index;
    this.monsterRow=row;
    this.monsterCol=col;
}
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
                action++;
                if (action==4){
                    action=0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Bitmap getMonsterMap() {
        return monsterMap;
    }

    public void setMonserMap(Bitmap monsterMap) {
        this.monsterMap = monsterMap;
    }

    public int getMonsterIndex() {
        return monsterIndex;
    }

    public void setMonsterIndex(int monsterIndex) {
        this.monsterIndex = monsterIndex;
    }

    public int getMonsterRow() {
        return monsterRow;
    }

    public void setMonsterRow(int monsterRow) {
        this.monsterRow = monsterRow;
    }

    public int getMonsterCol() {
        return monsterCol;
    }

    public void setMonsterCol(int monsterCol) {
        this.monsterCol = monsterCol;
    }

    public int getMonsterImageIndex() {
        return monsterImageIndex;
    }

    public void setMonsterImageIndex(int monsterImageIndex) {
        this.monsterImageIndex = monsterImageIndex;
    }
}
