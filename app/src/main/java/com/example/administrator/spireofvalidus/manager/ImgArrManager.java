package com.example.administrator.spireofvalidus.manager;

import com.example.administrator.spireofvalidus.drawimgarr.DrawImgArr;
import com.example.administrator.spireofvalidus.entity.Player;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ImgArrManager {
    /**玩家本层 位置X*/
    public static int x=0;
    /**玩家本层 位置Y*/
    public static int y=0;
    /**背景1 */
    public static int [][] bgImgArr=null;
    /**背景2 */
    public static int [][] bg2ImgArr=null;
    /**障碍物 */
    public static int [][] barrierImgArr=null;
    /**NPC */
    public static int [][] npcImgArr=null;
    /**怪物 */
    public static int [][] monsterImgArr=null;
    /**物品 */
    public static int [][] articleImgArr=null;
    /**门 */
    public static int [][] doorImgArr=null;
    /**楼梯 */
    public static int [][] stairwayImgArr=null;
    public static int[][] syScreenbgImgArr=null;

    public static void getZAWInfo(int djc){
        switch (djc){
            case 1:
                if (Player.loutiFlag){
                    x= DrawImgArr.acxx001;
                    y=DrawImgArr.acxy001;
                }else {
                    x=DrawImgArr.acx001;
                    y=DrawImgArr.acy001;
                }
                bgImgArr=DrawImgArr.bgImgArr001;
                bg2ImgArr=DrawImgArr.bg2ImgArr001;
                barrierImgArr=DrawImgArr.barrierImgArr001;
                monsterImgArr=DrawImgArr.monsterImgArr001;
                npcImgArr=DrawImgArr.npcImgArr001;
                articleImgArr=DrawImgArr.articleImgArr001;
                doorImgArr=DrawImgArr.doorImgArr001;
                stairwayImgArr=DrawImgArr.stairwayImgArr001;
                break;
            case 2:
                if (Player.loutiFlag){
                    x= DrawImgArr.acxx002;
                    y=DrawImgArr.acxy002;
                }else {
                    x=DrawImgArr.acx002;
                    y=DrawImgArr.acy002;
                }
                bgImgArr=DrawImgArr.bgImgArr002;
                bg2ImgArr=DrawImgArr.bg2ImgArr002;
                barrierImgArr=DrawImgArr.barrierImgArr002;
                monsterImgArr=DrawImgArr.monsterImgArr002;
                npcImgArr=DrawImgArr.npcImgArr002;
                articleImgArr=DrawImgArr.articleImgArr002;
                doorImgArr=DrawImgArr.doorImgArr002;
                stairwayImgArr=DrawImgArr.stairwayImgArr002;
                break;
            case 3:
                if (Player.loutiFlag){
                    x= DrawImgArr.acxx003;
                    y=DrawImgArr.acxy003;
                }else {
                    x=DrawImgArr.acx003;
                    y=DrawImgArr.acy003;
                }
                bgImgArr=DrawImgArr.bgImgArr003;
                bg2ImgArr=DrawImgArr.bg2ImgArr003;
                barrierImgArr=DrawImgArr.barrierImgArr003;
                monsterImgArr=DrawImgArr.monsterImgArr003;
                npcImgArr=DrawImgArr.npcImgArr003;
                articleImgArr=DrawImgArr.articleImgArr003;
                doorImgArr=DrawImgArr.doorImgArr003;
                stairwayImgArr=DrawImgArr.stairwayImgArr003;
                break;
            case 4:
                if (Player.loutiFlag){
                    x= DrawImgArr.acxx004;
                    y=DrawImgArr.acxy004;
                }else {
                    x=DrawImgArr.acx004;
                    y=DrawImgArr.acy004;
                }
                bgImgArr=DrawImgArr.bgImgArr004;
                bg2ImgArr=DrawImgArr.bg2ImgArr004;
                barrierImgArr=DrawImgArr.barrierImgArr004;
                monsterImgArr=DrawImgArr.monsterImgArr004;
                npcImgArr=DrawImgArr.npcImgArr004;
                articleImgArr=DrawImgArr.articleImgArr004;
                doorImgArr=DrawImgArr.doorImgArr004;
                stairwayImgArr=DrawImgArr.stairwayImgArr004;
                break;
            case 5:
                if (Player.loutiFlag){
                    x= DrawImgArr.acxx005;
                    y=DrawImgArr.acxy005;
                }else {
                    x=DrawImgArr.acx005;
                    y=DrawImgArr.acy005;
                }
                bgImgArr=DrawImgArr.bgImgArr005;
                bg2ImgArr=DrawImgArr.bg2ImgArr005;
                barrierImgArr=DrawImgArr.barrierImgArr005;
                monsterImgArr=DrawImgArr.monsterImgArr005;
                npcImgArr=DrawImgArr.npcImgArr005;
                articleImgArr=DrawImgArr.articleImgArr005;
                doorImgArr=DrawImgArr.doorImgArr005;
                stairwayImgArr=DrawImgArr.stairwayImgArr005;
                break;
            case 6:
//                if (Player.loutiFlag){
//                    x= DrawImgArr.acxx006;
//                    y=DrawImgArr.acxy006;
//                }else {
                    x=DrawImgArr.acx006;
                    y=DrawImgArr.acy006;
//                }
                bgImgArr=DrawImgArr.bgImgArr006;
                bg2ImgArr=DrawImgArr.bg2ImgArr006;
                barrierImgArr=DrawImgArr.barrierImgArr006;
                monsterImgArr=DrawImgArr.monsterImgArr006;
                npcImgArr=DrawImgArr.npcImgArr006;
                articleImgArr=DrawImgArr.articleImgArr006;
                doorImgArr=DrawImgArr.doorImgArr006;
                stairwayImgArr=DrawImgArr.stairwayImgArr006;
                break;
        }
    }
}
