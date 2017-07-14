package com.example.administrator.spireofvalidus.manager;

/**
 * Created by Administrator on 2017/7/10.
 */

public class TaskManager {
public static String[][] content=new String[10][10];
    public static int[] task=new int [10];
    public static boolean[] bool=new boolean[10];
    static {
        for (int i = 0; i <content.length ; i++) {
            content[i]=new String[10];
            for (int j = 0; j <content[i].length ; j++) {
                content[i][j]=new String();
            }
        }
    }
    public static void getRWContent(int index){
        switch(index){
            case 1:
                content[0][0]="仙子：--            欢迎你来到魔塔世界 !  --    我上次在第 3 层  的时候不小心--    把我的宝物【十字架】弄丢了。" +
                        "--    如果你能帮我找回来,我可以--    升你的力量！--  --    注: Hp、攻击、防御 各增幅1/3 ! ";
                content[0][1]="仙子：--            你找到【十字架】后，--    别忘记回来找我！";
                content[0][2]="仙子：--            谢谢你勇士！--    你获得了祝福！--    勇敢的去战斗吧！";
                content[0][3]="仙子：--            亲爱的勇士！--    你已经获得了祝福！--    勇敢的去战斗吧！";
                break;
        }
    }
}
