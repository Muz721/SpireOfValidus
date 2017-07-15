package com.example.administrator.spireofvalidus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.spireofvalidus.R;
import com.example.administrator.spireofvalidus.entity.Npc;
import com.example.administrator.spireofvalidus.entity.Player;
import com.example.administrator.spireofvalidus.manager.ArticleManager;
import com.example.administrator.spireofvalidus.manager.ImgArrManager;
import com.example.administrator.spireofvalidus.manager.ShopManager;
import com.example.administrator.spireofvalidus.manager.TaskManager;
import com.example.administrator.spireofvalidus.util.BitmapUtils;
import com.example.administrator.spireofvalidus.util.DataSynEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/7/10.
 *
 */

public class ShopAndNpcSayView extends ViewGroup{
    Button btnOne=null;
    Button btnTwo=null;
    Button btnThree=null;
    Button btnFour=null;
    TextView textView;
    public int npcIndex,npcrow,npccol;
    public int shopIndex=1;
    Npc npc=null;
    Player player=null;
    public Handler handler=null;
boolean task=false;
    public ShopAndNpcSayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        npc=Npc.getNpc();
        player=Player.getPlayer(context);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView,int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.e("---onVis---","onVisibilityChanged"+"-------"+visibility);
        if (visibility==View.VISIBLE&&npcIndex/3!=0){
            ShopManager.getShopInfo(shopIndex);
            shopTouchListener stl=new shopTouchListener();
            if (btnOne==null&&btnTwo==null&&btnThree==null){
                btnOne=new Button(this.getContext());
                btnOne.setText(ShopManager.shopTitle[1]);
                btnOne.layout((BitmapUtils.WIDTH/100)*10, (BitmapUtils.HEIGHT/100)*15, (BitmapUtils.WIDTH/100)*90, (BitmapUtils.HEIGHT/100)*20);
                btnOne.setPadding(0, 5, 0, 5);
                btnOne.setGravity(Gravity.CENTER);
                btnOne.setOnTouchListener(stl);
                this.addView(btnOne);
                btnTwo=new Button(this.getContext());
                btnTwo.setText(ShopManager.shopTitle[2]);
                btnTwo.layout((BitmapUtils.WIDTH/100)*10, (BitmapUtils.HEIGHT/100)*21, (BitmapUtils.WIDTH/100)*90, (BitmapUtils.HEIGHT/100)*26);
                btnTwo.setPadding(0, 5, 0, 5);
                btnTwo.setGravity(Gravity.CENTER);
                btnTwo.setOnTouchListener(stl);
                this.addView(btnTwo);
                btnThree=new Button(this.getContext());
                btnThree.setText(ShopManager.shopTitle[3]);
                btnThree.layout((BitmapUtils.WIDTH/100)*10, (BitmapUtils.HEIGHT/100)*27, (BitmapUtils.WIDTH/100)*90, (BitmapUtils.HEIGHT/100)*32);
                btnThree.setPadding(0, 5, 0, 5);
                btnThree.setGravity(Gravity.CENTER);
                btnThree.setOnTouchListener(stl);
                this.addView(btnThree);
                if(btnFour==null){
                    btnFour=new Button(this.getContext());
                    btnFour.setText(ShopManager.shopTitle[4]);
                    btnFour.layout(75, 300, 405, 350);
                    btnFour.setPadding(0, 5, 0, 5);
                    btnFour.setGravity(Gravity.CENTER);
                    btnFour.setOnTouchListener(stl);
                    this.addView(btnFour);
                }else{
                    btnFour.setText(ShopManager.shopTitle[4]);
                }
            }else {
                btnOne.setVisibility(View.VISIBLE);
                btnTwo.setVisibility(View.VISIBLE);
                btnThree.setVisibility(View.VISIBLE);
                btnOne.setText(ShopManager.shopTitle[1]);
                btnTwo.setText(ShopManager.shopTitle[2]);
                btnThree.setText(ShopManager.shopTitle[3]);
                btnFour.setText(ShopManager.shopTitle[4]);
            }
            btnbghei();
        }else if (visibility==View.VISIBLE&&npcIndex/3==0){
            //如果按钮实例已创建、则隐藏按钮
            if(btnOne!=null&&btnTwo!=null){
                btnOne.setVisibility(View.INVISIBLE);
                btnTwo.setVisibility(View.INVISIBLE);
                btnThree.setVisibility(View.INVISIBLE);
            }
            shopTouchListener stl=new shopTouchListener();
            if(btnFour==null){
                btnFour=new Button(this.getContext());
                btnFour.setText("继续");
//                btnFour.layout(75, 225, 405, 270);
                Log.e("--100)*25---",(BitmapUtils.HEIGHT/100)*25+"");
                Log.e("-(BitmapUtils.HEIGHT--",(float)(BitmapUtils.HEIGHT/1000)*385+"");
//                textView.
                btnFour.layout((BitmapUtils.WIDTH/100)*10, (BitmapUtils.HEIGHT/100)*33, (BitmapUtils.WIDTH/100)*90, (BitmapUtils.HEIGHT/100)*38);
//                btnFour.layout((BitmapUtils.WIDTH/100)*10, (int) (( (float)BitmapUtils.HEIGHT/1000)*310), (BitmapUtils.WIDTH/100)*100, (int) (( (float)BitmapUtils.HEIGHT/1000)*360));
                btnFour.setPadding(0, 5, 0, 5);
                btnFour.setGravity(Gravity.CENTER);
                btnFour.setOnTouchListener(stl);
                this.addView(btnFour);
            }
            if(!TaskManager.bool[0]){
                btnFour.setText("接受任务");
            }else{
                if(player.tsWpMap.get(ArticleManager.CROSS)==null){
                    if(TaskManager.task[0]!=3){
                        TaskManager.task[0]=1;
                    }
                }else{
                    TaskManager.task[0]=2;
                    task=true;
//                    player.setHp(player.getHp()+player.getHp()/3);
//                    player.setAtk(player.getAtk()+player.getAtk()/3);
//                    player.setDef(player.getDef()+player.getDef()/3);
                    Log.e("-------------------","---------------------");
//                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
//                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getAtk(),10));
//                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getDef(),11));
//                    player.tsWpMap.put(ArticleManager.CROSS, null);
                }
                btnFour.setText("关闭");
            }
            btnbghei();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas1=new Canvas();
        canvas1=canvas;
        Paint paint=new Paint();
        paint.setTextSize(20);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.WHITE);
        if (npcIndex/3==0){
            if(TaskManager.content[0][TaskManager.task[0]]!=null){
                String [] str=TaskManager.content[0][TaskManager.task[0]].split("--");
                    npc.drawImg(canvas,80,10,0,npcIndex/3*(player.getPlayerMap().getWidth()/3),64,64);
//                    TextPaint textPaint=new TextPaint();
//                    textPaint.setTextSize(15);
//                    canvas.drawText(str[0],160,0==0?60:0*25+60,paint);
//                    StaticLayout layout=new StaticLayout(str[0],textPaint,240, Layout.Alignment.ALIGN_NORMAL,1.0F,1.0F,false);
//
//                    canvas1.translate(80,80);
//                    layout.draw(canvas1);
                for (int i = 0; i <str.length ; i++) {
                    canvas.drawText(str[i],160,i==0?60:i*25+60,paint);
                }
            }
        }else {
            if (ShopManager.shopTitle!=null){
                String [] str=ShopManager.shopTitle[0].split("--");
                    npc.drawImg(canvas,80,10,0,npcIndex/3*(player.getPlayerMap().getWidth()/3),64,64);
                for (int i = 0; i <str.length ; i++) {
//                    canvas.drawText(str[i],160,i==0?60:i*25+60,paint);
//                    TextPaint textPaint=new TextPaint();
//                    textPaint.setTextSize(35);
                    canvas.drawText(str[i],160,i==0?60:i*25+60,paint);
//                    StaticLayout layout=new StaticLayout(str[i],textPaint,240, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);
//                    canvas.translate(20,80);
//                    layout.draw(canvas);
//                    npc.drawImg(canvas,80,10,0,npcIndex/3*(player.getPlayerMap().getWidth()/3),64,64);
//                    canvas.drawText(str[i],90,i==0?200:i*25+200,paint);
                }
//                    TextPaint textPaint=new TextPaint();
//                    textPaint.setTextSize(15);
//                    canvas.drawText(str[0],160,0==0?60:0*25+60,paint);
//                    StaticLayout layout=new StaticLayout(str[0],textPaint,50, Layout.Alignment.ALIGN_OPPOSITE,1.0F,0.0F,false);
//                layout.
//                canvas1.
//                    canvas1.translate(80,80);
//                    layout.draw(canvas1);
//                canvas1.restore();
            }
        }
    }

    class shopTouchListener implements OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction()==0){
                Button btn= (Button) v;
                btn.setBackgroundResource(R.drawable.huishopxxbg);
                btn.setTextColor(Color.YELLOW);
            }
            if (v==btnOne&&event.getAction()==1){
                if (shopIndex==4){
                    player.addLevel(ShopManager.BuffVale[0],ShopManager.XHValue[0]);
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getLevel(),15));
                }else if (shopIndex==2){
                    if (player.getMoney()-ShopManager.XHValue[0]>=0){
                    player.setGoldKey(player.getGoldKey()+ShopManager.BuffVale[0]);
                    player.setMoney(player.getMoney()-ShopManager.XHValue[0]);}
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getGoldKey(),12));
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                }else if(shopIndex==3||shopIndex==5){
                    if (player.getMoney()-ShopManager.XHValue[0]>=0){
                        player.setHp(player.getHp()+ShopManager.BuffVale[0]);
                        player.setMoney(player.getMoney()-ShopManager.XHValue[0]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    }
                }
            }else if (v==btnTwo&&event.getAction()==1){
                if (shopIndex==4){
                    if (player.getExp()-ShopManager.XHValue[1]>=0){
                        player.setAtk(player.getAtk()+ShopManager.BuffVale[1]);
                        player.setExp(player.getExp()-ShopManager.XHValue[0]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getAtk(),10));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getExp(),15));
                    }
                }else if (shopIndex==2){
                    if (player.getMoney()-ShopManager.XHValue[1]>=0){
                        player.setSilverKey(player.getSilverKey()+ShopManager.BuffVale[1]);
                        player.setMoney(player.getMoney()-ShopManager.XHValue[1]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getSilverKey(),13));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    }
                }else if(shopIndex==3||shopIndex==5){
                    if (player.getMoney()-ShopManager.XHValue[1]>=0){
                        player.setAtk(player.getAtk()+ShopManager.BuffVale[1]);
                        player.setMoney(player.getMoney()-ShopManager.XHValue[1]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getAtk(),10));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    }
                }
            }else if (v==btnThree&&event.getAction()==1){
                if (shopIndex==4){
                    if (player.getExp()-ShopManager.XHValue[2]>=0){
                        player.setDef(player.getDef()+ShopManager.BuffVale[2]);
                        player.setExp(player.getExp()-ShopManager.XHValue[2]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getDef(),11));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getExp(),15));
                    }
                }else if (shopIndex==2){
                    if (player.getMoney()-ShopManager.XHValue[2]>=0){
                        player.setCopperKey(player.getCopperKey()+ShopManager.BuffVale[2]);
                        player.setMoney(player.getExp()-ShopManager.XHValue[2]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getCopperKey(),14));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    }
                }else if (shopIndex==3||shopIndex==5){
                    if (player.getMoney()-ShopManager.XHValue[2]>=0){
                        player.setDef(player.getDef()+ShopManager.BuffVale[2]);
                        player.setMoney(player.getMoney()-ShopManager.XHValue[2]);
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getDef(),11));
                        EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
                    }
                }
            }
            if (v==btnFour&&event.getAction()==1){
                invisibilethis();
//                EventBus.getDefault().postSticky(new DataSynEvent("8",8));
                if (npcIndex/3==0){
                    if (!TaskManager.bool[0]){
                        TaskManager.bool[0]=true;
                        ImgArrManager.npcImgArr[npcrow][npccol]=0;
                        ImgArrManager.npcImgArr[npcrow][npccol+1]=npcIndex;
                    }
                    if (TaskManager.task[0]==2){
                        TaskManager.task[0]=3;
                    }
                }
                if (task){
                    player.setHp(player.getHp()+player.getHp()/3);
                    player.setAtk(player.getAtk()+player.getAtk()/3);
                    player.setDef(player.getDef()+player.getDef()/3);
                    task=false;
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getAtk(),10));
                    EventBus.getDefault().postSticky(new DataSynEvent(""+player.getDef(),11));
                    player.tsWpMap.put(ArticleManager.CROSS, null);
                }
            }
            if (event.getAction()==1){
                btnbghei();
            }
            return false;
        }
    }

    private void invisibilethis() {
        EventBus.getDefault().postSticky(new DataSynEvent("8",8));
        this.setVisibility(View.INVISIBLE);
    }

    private void btnbghei() {
        if (npcIndex/3!=0){
            btnOne.setBackgroundResource(R.drawable.heishopxxbg);
            btnOne.setTextColor(Color.LTGRAY);
            btnTwo.setBackgroundResource(R.drawable.heishopxxbg);
            btnTwo.setTextColor(Color.LTGRAY);
            btnThree.setBackgroundResource(R.drawable.heishopxxbg);
            btnThree.setTextColor(Color.LTGRAY);
        }
        btnFour.setBackgroundResource(R.drawable.heishopxxbg);
        btnFour.setTextColor(Color.LTGRAY);
    }


}
