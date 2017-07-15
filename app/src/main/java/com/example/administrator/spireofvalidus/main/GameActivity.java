package com.example.administrator.spireofvalidus.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.spireofvalidus.BaseActivity;
import com.example.administrator.spireofvalidus.MainActivity;
import com.example.administrator.spireofvalidus.R;
import com.example.administrator.spireofvalidus.entity.Article;
import com.example.administrator.spireofvalidus.entity.Door;
import com.example.administrator.spireofvalidus.entity.Monster;
import com.example.administrator.spireofvalidus.entity.Player;
import com.example.administrator.spireofvalidus.manager.ArticleManager;
import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.MonsterManager;
import com.example.administrator.spireofvalidus.manager.TaskManager;
import com.example.administrator.spireofvalidus.util.DataSynEvent;
import com.example.administrator.spireofvalidus.view.CombatView;
import com.example.administrator.spireofvalidus.view.DMessageView;
import com.example.administrator.spireofvalidus.view.ShopAndNpcSayView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/6.
 */

public class GameActivity extends BaseActivity {
    @BindView(R.id.btnTop)
    Button btnTop;
    @BindView(R.id.btnMonster)
    Button btnMonster;
    @BindView(R.id.btnLeft)
    Button btnLeft;
    @BindView(R.id.btnRight)
    Button btnRight;
    @BindView(R.id.btnDown)
    Button btnDown;
    @BindView(R.id.btnExchangeTier)
    Button btnExchangeTier;
    @BindView(R.id.user_img)
    ImageView userImg;
    @BindView(R.id.HP)
    TextView HP;
    @BindView(R.id.ATK)
    TextView ATK;
    @BindView(R.id.DEF)
    TextView DEF;
    @BindView(R.id.user_message)
    TextView userMessage;
    @BindView(R.id.goldKey)
    TextView goldKey;
    @BindView(R.id.silverKey)
    TextView silverKey;
    @BindView(R.id.copperKey)
    TextView copperKey;
    /**
     * 判断是否在战斗或者对话
     */
    public static boolean keyFlag;
    /**
     * 玩家
     */
    Player player;
    /**
     * 怪物
     */
    Monster monster;
    /**
     * 物品
     */
    Article article;
    /**
     * 门
     */
    Door door;
    /**
     * 根据按键人物(用于)移动范围
     */
    int x = 0, y = 0;
    int ydIndex = 0, indexRow = 0, indexColumn = 0;//遇到NPC或GuaiWu (结果，二维数组下标)
    Thread runMove = null;//移动线程
    /**
     * 战斗
     */
    @BindView(R.id.combat)
    CombatView combat;
    @BindView(R.id.dMessage)
    DMessageView dMessage;
    @BindView(R.id.shopAndNpc)
    ShopAndNpcSayView shopAndNpc;
int xx;
    int playX;
    int playY;
    boolean direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        player = Player.getPlayer(this);
        ImgArrManager.getZAWInfo(player.getMtStorey());
        player.setMyX(ImgArrManager.x);
        player.setMyY(ImgArrManager.y);
        super.onCreate(savedInstanceState, R.layout.activity_game);
        Log.e("-----","---"+shopAndNpc.getVisibility());
//        EventBus.getDefault().
        HP.setText(""+player.getHp()+"");
        ATK.setText(""+player.getAtk()+"");
        DEF.setText(""+player.getDef()+"");
        goldKey.setText(""+player.getGoldKey()+"");
        silverKey.setText(""+player.getSilverKey()+"");
        copperKey.setText(""+player.getCopperKey()+"");
        userMessage.setText("【第"+player.getMtStorey()+"层】" + "\t" + "等级:" +  player.getLevel() + "\n" + "金币:" + player.getMoney() + "\t" + "经验" + player.getExp());
        EventBus.getDefault().register(this);//订阅
//        initView();
    }

    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!false){
                    try {
        HP.setText(""+player.getHp()+"");
                        userMessage.setText("【第一层】" + "\t" + "等级:" + "1" + "1" + "\n" + "金币:" + "200" + "\t" + "经验" + "100");
                        Thread.sleep(1000);
                        Log.e("-----","-----");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//
            }
        }).start();
    }

    /**
     * 处理订阅消息
     *
     * @param event 订阅消息
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void eventComing(DataSynEvent event) {
        if(event.getCount() == 1){
            System.out.println("胜利！NewGame01 已收到！");
            Log.e("-----","胜利！NewGame01 已收到！");
            //胜利后移除怪物
            if(!monster.removeMonster(ImgArrManager.monsterImgArr)){
                System.out.println("战斗胜利后移除怪物...异常！");
            }
            keyFlag=true;
        }else
        if (event.getCount() == 2) {
            keyFlag = true;
            Log.e("---2222222--", "1111");
        } else  if (event.getCount() == 5) {
            keyFlag = true;
            Log.e("---5-", "1111");
            Log.e("keyFlag",""+keyFlag);
        }else  if (event.getCount() == 6) {
            keyFlag = true;
            Log.e("---888", "1111");
        }else if (event.getCount() == 8) {
            keyFlag = true;
            Log.e("---88--", "1111");
        }else if (event.getCount()==9){
            HP.setText(""+player.getHp()+"");
        } else if (event.getCount()==10){
            ATK.setText(""+player.getAtk()+"");
        }else if (event.getCount()==11){
            DEF.setText(""+player.getDef()+"");
        } else if (event.getCount()==12){
            goldKey.setText(""+player.getGoldKey()+"");
        }else if (event.getCount()==13){
            silverKey.setText(""+player.getSilverKey()+"");
        }else if (event.getCount()==14){
            copperKey.setText(""+player.getCopperKey()+"");
        }else if (event.getCount()==15){
            userMessage.setText("【第"+player.getMtStorey()+"层】" + "\t" + "等级:" +  player.getLevel() + "\n" + "金币:" + player.getMoney() + "\t" + "经验" + player.getExp());
        }
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            if(msg.arg1==1){
//                System.out.println("胜利！NewGame01 已收到！");
//                //胜利后移除怪物
//                if(!monster.removeMonster(ImgArrManager.monsterImgArr)){
//                    System.out.println("战斗胜利后移除怪物...异常！");
//                }
//                keyFlag=true;
//            }else if(msg.arg1==2) {
//                System.out.println("失败！NewGame01 已收到！");
//                keyFlag=true;
//            }else if(msg.arg1==5){
//                System.out.println("短消息视图关闭、NewGame01 已收到！");
//                keyFlag=true;
//            }else if(msg.arg1==6){
//                System.out.println("门已打开、NewGame01 已收到！");
//                keyFlag=true;
//            }else if(msg.arg1==8){
//                System.out.println("商店窗口关闭、NewGame01 已收到！");
//                keyFlag=true;
//            }
//            super.handleMessage(msg);
        }
    };
    //    public void
    @OnClick({R.id.btnTop, R.id.btnMonster, R.id.btnLeft, R.id.btnRight, R.id.btnDown, R.id.btnExchangeTier})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnTop:
            case R.id.btnLeft:
            case R.id.btnRight:
            case R.id.btnDown:
                move(view.getId());

                break;
            case R.id.btnMonster:
                break;
            case R.id.btnExchangeTier:
                break;
        }
    }

    private void move(int id) {
        int result = 0;
        int x = 0;
        int y = 0;
Log.e("--key---",""+keyFlag);
        if (keyFlag) {
            actorCheckZAWMove(result, x, y, id);
        }

    }

    private void actorCheckZAWMove(int result, int x, int y, int id) {
        if (id == btnTop.getId()) {
            x = 0;
            y = -(player.getPlayerMap().getHeight()/4);
            Log.e("-xxxx---","----"+y);
            result = CheckBCZAW(x, y);
            player.setFx(3);
        } else if (id == btnDown.getId()) {
            x = 0;
            y += player.getPlayerMap().getHeight()/4;
            result = CheckBCZAW(x, y);
            player.setFx(0);
        } else if (id == btnLeft.getId()) {
            x = -(player.getPlayerMap().getHeight()/4);
            y = 0;
            result = CheckBCZAW(x, y);
            player.setFx(1);
        } else if (id == btnRight.getId()) {
            x = +(player.getPlayerMap().getHeight()/4);
            y = 0;
            result = CheckBCZAW(x, y);
            player.setFx(2);
        }
        checkResult(result, x, y);
    }

    private void checkResult(int result, int x, int y) {
        switch (result) {
            case 0:
                if (this.x != 0 || this.y != 0) {
                    break;
                }
//                Log.e("人物移动", "-----x-----"+x);
//                Log.e("人物移动", "-----y-----"+y);
                this.x = x;
                this.y = y;
                getRunMove().start();
                break;
            case 1:
                	Log.e("人物移动", "遇到障碍物。。。");
                break;
            case 2:
                shopAndNpc.npcIndex = ydIndex;
                shopAndNpc.shopIndex = ydIndex / 3 + 1;
                if (ydIndex / 3 == 0) {
                    shopAndNpc.npcrow = indexRow;
                    shopAndNpc.npccol = indexColumn;
                    TaskManager.getRWContent(1);
                }
                shopAndNpc.setVisibility(View.VISIBLE);
                Log.e("--------NPC","__npc");
                keyFlag = false;
                break;
            case 3:
                this.monster = MonsterManager.getMonster(ydIndex);
                this.monster.setMonsterArrInfo(ydIndex, indexRow, indexColumn);
                combat.monster = monster;
                combat.handler=this.handler;
                combat.setVisibility(View.VISIBLE);
                keyFlag = false;
                Log.e("------","------");
                break;
            case 4:
                //遇到物品
                this.article = ArticleManager.getArticle(ydIndex);
                this.article.setArticleArrInfo(ydIndex, indexRow, indexColumn);
                String title = this.article.getArticleNameStr(this.player);
                String content = this.article.getArticleInfo();
                dMessage.setTitle(title);
                dMessage.handler=handler;
                dMessage.setContent(content);
                dMessage.setVisibility(View.VISIBLE);
                if (!this.article.removeArticle(ImgArrManager.articleImgArr)) {
                }
                keyFlag = false;
                break;
            case 5:
                //遇到门
                door = Door.getDoor(this);
                door.setKey(ydIndex);
                door.setDoorArrInfo(ydIndex, indexRow, indexColumn);
                String titlea = door.getDoorDkStr(this.player);
                dMessage=(DMessageView) findViewById(R.id.dMessage);
                dMessage.setTitle(titlea);
                dMessage.setContent("");
                dMessage.handler=this.handler;
                dMessage.setVisibility(View.VISIBLE);
                if (!door.isCheckPlayerTG())
                    return;
                if (!this.door.removeDoor(ImgArrManager.doorImgArr)) {
                    System.out.println("门移除异常！");
                }
                door.setHandler(this.handler);
                Log.e("----","---");
                keyFlag = false;
                break;
            case 6:
                //遇到楼梯
                if (this.ydIndex >= 16 && this.ydIndex <= 19) {
                    Player.loutiFlag = false;
                    player.setMtStorey(player.getMtStorey() + 1);
//                    Intent intent=new Intent();
//                    intent.setClass(this, LoadingActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
                    finishTopStartActivity(LoadingActivity.class);
                    keyFlag = false;
                } else if (this.ydIndex >= 40 && this.ydIndex <= 43) {
                    Player.loutiFlag = true;
                    player.setMtStorey(player.getMtStorey() - 1);
//                    Intent intent=new Intent();
//                    intent.setClass(this, LoadingActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
                    finishTopStartActivity(LoadingActivity.class);
                    keyFlag = false;
                }
                break;
        }
    }

    public boolean checkZAW(int[][] zaw, int ax, int ay) {
        int x = (int) player.getMyX();
        int y = (int) player.getMyY();
        for (int row = 0; row < zaw.length; row++) {
            for (int column = 0; column < zaw[row].length; column++) {
                int value = zaw[row][column];
                if (value != 0) {
                    int zx = column * (player.getPlayerMap().getWidth()/3);
                    int zy = row * (player.getPlayerMap().getHeight()/4);
                    if (x + ax == zx && y + ay == zy) {
                        this.indexRow = row;
                        this.indexColumn = column;
                        this.ydIndex = value;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int CheckBCZAW(int x, int y) {
        if (ImgArrManager.barrierImgArr == null || checkZAW(ImgArrManager.barrierImgArr, x, y)) {
            if (ImgArrManager.npcImgArr == null || checkZAW(ImgArrManager.npcImgArr, x, y)) {
                if (ImgArrManager.monsterImgArr == null || checkZAW(ImgArrManager.monsterImgArr, x, y)) {
                    if (ImgArrManager.articleImgArr == null || checkZAW(ImgArrManager.articleImgArr, x, y)) {
                        if (ImgArrManager.doorImgArr == null || checkZAW(ImgArrManager.doorImgArr, x, y)) {
                            if (ImgArrManager.stairwayImgArr == null || checkZAW(ImgArrManager.stairwayImgArr, x, y)) {
                                //System.out.println("判断 通过  "+System.currentTimeMillis());
                                return 0;//通过
                            } else {
                                return 6;//遇到楼梯
                            }
                        } else {
                            return 5;//遇到门
                        }
                    } else {
                        return 4;//遇到物品
                    }
                } else {
                    return 3;//遇到怪物
                }
            } else {
                return 2;//遇到NPC
            }
        } else {
            return 1;//遇到障碍物
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅
    }

    public Thread getRunMove() {
//        Log.e("------aaa------","---"+player.getMyX());
        if (runMove == null) {
            playX=player.getMyX();
            playY=player.getMyY();
            runMove = new Thread(new RunMove());
        }
        return runMove;
    }

    class RunMove implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
//        Log.e("------aaaa-----","---"+player.getMyX());
                try {
                    Thread.sleep(80);
                    int speedx = 0, speedy = 0;
                    xx++;
//                    Log.e("----","----"+xx);
//                    Log.e("---ss--","----"+(player.getPlayerMap().getWidth()/3)/4);
//                    Log.e("----x--","-----"+player.getPlayerMap().getWidth());
//                    Log.e("----y--","-----"+player.getPlayerMap().getHeight());
                    speedx = x > 0 ? (player.getPlayerMap().getWidth()/3)/4: -((player.getPlayerMap().getWidth()/3)/4);
                    speedy = y > 0 ?(player.getPlayerMap().getWidth()/3)/4 : -((player.getPlayerMap().getWidth()/3)/4);
                    Log.e("--x---","--x--"+x);
                    Log.e("--speedy---","--y--s"+speedx);
                    if ((x<0&&x <= speedx)||(x>0&&x>=speedx)) {
                        x -= speedx;
                        player.setMyX(player.getMyX() + speedx);
//                        Log.e("-----","-speedx=="+speedx);
//                    Log.e("--x---","--x--"+x);
//                    Log.e("--y---","--y--s"+y);
//                    Log.e("--speedy---","--y--s"+speedy);
//                    Log.e("------------","---"+player.getMyX());
                        direction=false;
                    }
                    if ((y<0&&y <= speedy)||(y>0&&y>=speedy)) {
                        y -= speedy;
                        player.setMyY(player.getMyY() + speedy);
                        direction=true;
                    }
//                    if (x > speedx) {
//                        x += speedx;
//                        player.setMyX(player.getMyX() + speedx);
//                        Log.e("-----","-speedx=="+speedx);
//                    }
//                    if (y > speedy) {
//                        y += speedy;
//                        player.setMyY(player.getMyY() + speedy);
//                    }
                    if (direction&&y<=0&&y>speedy&& x==0) {
                        y=0;
                        player.setMyY(playY-(player.getPlayerMap().getWidth()/3));
//                        Log.e("--xyyyyy---","--x--"+x);
//                        Log.e("--y-yyyyy--","--y--s"+y);
//                        Log.e("--speedy-yyy--","--y--s"+speedy);
//                        Log.e("-------yyyy-----","---"+player.getMyX());
                        runMove.interrupt();
                        runMove = null;
                    }
                    else if (!direction&&x<=0&&x>speedx&& y==0){
                        Log.e("--x---","--x--"+x);
                        Log.e("--y---","--y--s"+y);
                        Log.e("--speedy---","--y--s"+speedx);
                        Log.e("------------","---"+player.getMyX());
                        x=0;
                        player.setMyX(playX-(player.getPlayerMap().getWidth()/3));
                        runMove.interrupt();
                        runMove = null;
                    }
                    else if (direction&&y>=0&&y<speedy&& x==0){
//                        Log.e("--y---","--x--"+y);
                        y=0;
                        player.setMyY(playY+(player.getPlayerMap().getWidth()/3));
                        runMove.interrupt();
                        runMove = null;
                    }else if (!direction&&x>=0&&x<speedx&& y==0){
                        player.setMyX(playX+(player.getPlayerMap().getWidth()/3));
                        x=0;
                        runMove.interrupt();
                        runMove = null;
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent();
            intent.setClass(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return false;
    }
}
