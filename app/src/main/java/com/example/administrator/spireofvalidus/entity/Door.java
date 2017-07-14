package com.example.administrator.spireofvalidus.entity;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.example.administrator.spireofvalidus.manager.ArticleManager;
import com.example.administrator.spireofvalidus.util.DataSynEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/7/11.
 */

public class Door extends View{
    private  int key=0;		//0黄，1蓝，2红，3，铁(特殊，需要铁镐)
    public boolean checkDraw=false;
    private  int action=0;		//动作
    private Handler handler=null;
    private int doorIndex,doorRow,doorCol;//物品所在二维数组
    private boolean checkPlayerTG;	//验证玩家是否拥有开启此门的条件
    //单例
    private Door(Context context) {
        super(context);
    }
    private static Door door=null;
    public static  Door getDoor(Context context) {
        if(door==null){
            door=new Door(context);
        }
        return door;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
        this.action=0;
        this.checkDraw=true;
        this.handler.post(runnable);
    }
    public String getDoorDkStr(Player player){
        this.checkPlayerTG=false;
        if(this.key==0){
            if(player.getGoldKey()<=0){
                return "您没有金钥匙！";
            }else{
               player.setGoldKey(player.getGoldKey()-1);
                this.checkPlayerTG=true;
                EventBus.getDefault().postSticky(new DataSynEvent(""+player.getGoldKey(),12));
                return "消耗：金钥匙 * 1 ！";
            }
        }
        if(this.key==1){
            if(player.getSilverKey()<=0){
                return "您没有银钥匙！";
            }else{
               player.setSilverKey(player.getSilverKey()-1);
                this.checkPlayerTG=true;
                EventBus.getDefault().postSticky(new DataSynEvent(""+player.getSilverKey(),13));
                return "消耗：银钥匙 * 1 ！";
            }
        }
        if(this.key==2){
            if(player.getCopperKey()<=0){
                return "您没有铜钥匙！";
            }else{
               player.setCopperKey(player.getCopperKey()-1);
                this.checkPlayerTG=true;
                EventBus.getDefault().postSticky(new DataSynEvent(""+player.getCopperKey(),14));
                return "消耗：铜钥匙 * 1 ！";
            }
        }
        if(this.key==3){
            if(player.tsWpMap.get(ArticleManager.PICKMATTOCK)==null){
                return "您还没有 获得【"+ArticleManager.PICKMATTOCK+"】！";
            }else{
               player.setGoldKey(player.getGoldKey()-1);
                this.checkPlayerTG=true;
                return "您使用了 【"+ArticleManager.PICKMATTOCK+"】 ！";
            }
        }
        return "";
    }
    //移除数组中的门
    public boolean removeDoor(int [][] menArr){
        if(menArr[doorRow][doorCol]==doorIndex){
            menArr[doorRow][doorCol]=0;
            return true;
        }else{
            return false;
        }
    }
    //获得门在数组中的信息
    public void setDoorArrInfo(int index,int row,int col){
        this.doorIndex=index;
        this.doorRow=row;
        this.doorCol=col;
    }
//    Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            action++;
//            if(action==4){
//                checkDraw=false;
//                action=0;
//                EventBus.getDefault().postSticky(new DataSynEvent("6",6));
//                Message message=handler.obtainMessage();
//                message.arg1=6;
//                handler.sendMessage(message);
//                System.out.println("将门打开的结果发送给 activity   ........");
//                handler.removeCallbacks(runnable);
//                move();
//            }else{
////                handler.postDelayed(runnable, 300);
//            }
//        }
//    };
Runnable runnable=new Runnable() {
    @Override
    public void run() {
        action++;
        if(action==4){
            checkDraw=false;
            action=0;
            EventBus.getDefault().postSticky(new DataSynEvent("6",6));
//            Message message=handler.obtainMessage();
//            message.arg1=6;
//            handler.sendMessage(message);
            System.out.println("将门打开的结果发送给 activity   ........");
            handler.removeCallbacks(runnable);
        }else{
            handler.postDelayed(runnable, 300);
        }
    }
};


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key/4;
    }
    public int getDoorIndex() {
        return doorIndex;
    }
    public void setDoorIndex(int doorIndex) {
        this.doorIndex = doorIndex;
    }
    public int getDoorRow() {
        return doorRow;
    }
    public void setDoorRow(int doorRow) {
        this.doorRow = doorRow;
    }
    public int getDoorCol() {
        return doorCol;
    }
    public void setDoorCol(int doorCol) {
        this.doorCol = doorCol;
    }
    public int getaction() {
        return action;
    }
    public void setaction(int action) {
        this.action = action;
    }
    public void setCheckPlayerTG(boolean checkPlayerTG) {
        this.checkPlayerTG = checkPlayerTG;
    }
    public boolean isCheckPlayerTG() {
        return checkPlayerTG;
    }
}
