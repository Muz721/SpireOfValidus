package com.example.administrator.spireofvalidus.manager;

import com.example.administrator.spireofvalidus.entity.Monster;

/**
 * Created by Administrator on 2017/7/11.
 */

public class MonsterManager {
    public static Monster getMonster(int imgIndex){
        Monster monster=new Monster();
        int index=imgIndex/4;
        switch (index){
            case 0:
                monster.initMonster("小骷髅", 300, 50, 20,50,30, index);
                break;
            case 1:
                monster.initMonster("刀盾骷髅", 800, 80, 30,80,40, index);
                break;
            case 2:
                monster.initMonster("狂暴骷髅", 77, 6, 8,5,8, index);
                break;
            case 3:
                monster.initMonster("钢甲骷髅", 100, 6, 8,5,8, index);
                break;
            case 4:
                monster.initMonster("小蝙蝠", 150, 15, 3,10,15, index);
                break;
            case 5:
                monster.initMonster("大蝙蝠", 1000, 90, 70,120,70, index);
                break;
            case 6:
                monster.initMonster("烈焰蝙蝠", 2000, 200, 180,200,150, index);
                break;
            case 7:
                monster.initMonster("黑袍法师", 100, 6, 8,5,8, index);
                break;
            case 8:
                monster.initMonster("青泡泡", 150, 25, 2,20,15, index);
                break;
            case 9:
                monster.initMonster("红泡泡", 100, 15, 2,10,10, index);
                break;
            case 10:
                monster.initMonster("黑泡泡", 200, 15, 3,30,10, index);
                break;
            case 11:
                monster.initMonster("大脸鸟", 100, 6, 8,5,8, index);
                break;
            case 12:
                monster.initMonster("蓝袍巫师", 500, 20, 5,30,20, index);
                break;
            case 13:
                monster.initMonster("红袍巫师", 100, 6, 8,5,8, index);
                break;
            case 14:
                monster.initMonster("灰法师", 100, 6, 8,5,8, index);
                break;
            case 15:
                monster.initMonster("红法师", 100, 6, 8,5,8, index);
                break;
            case 16:
                monster.initMonster("兽人", 500, 50, 50,100,50, index);
                break;
            case 17:
                monster.initMonster("刀盾兽人", 100, 6, 8,5,8, index);
                break;
            case 18:
                monster.initMonster("石像头", 2500, 180, 150,120,100, index);
                break;
            case 19:
                monster.initMonster("鼻涕人", 100, 6, 8,5,8, index);
                break;
            case 20:
                monster.initMonster("石头人", 1000, 80, 60,100,50, index);
                break;
            case 21:
                monster.initMonster("蓝甲石人", 100, 6, 8,5,8, index);
                break;
            case 22:
                monster.initMonster("红甲石人", 100, 6, 8,5,8, index);
                break;
            case 23:
                monster.initMonster("盗贼", 100, 6, 8,5,8, index);
                break;
            case 24:
                monster.initMonster("魔王", 5000, 300, 220,88,88, index);
                break;
            case 25:
                monster.initMonster("红眼狼头", 100, 6, 8,5,8, index);
                break;
            case 26:
                monster.initMonster("狐狸精", 100, 6, 8,5,8, index);
                break;
            case 27:
                monster.initMonster("蝙蝠精", 2500, 190, 160,150,100, index);
                break;
            case 28:
                monster.initMonster("小超人", 100, 6, 8,5,8, index);
                break;
            case 29:
                monster.initMonster("巨蝠超人", 3000, 200, 200,300,200, index);
                break;
            case 30:
                monster.initMonster("剑盾超人", 100, 6, 8,5,8, index);
                break;
            case 31:
                monster.initMonster("超人教官", 100, 6, 8,5,8, index);
                break;
            case 32:
                monster.initMonster("红甲卫士", 100, 6, 8,5,8, index);
                break;
            case 33:
                monster.initMonster("邪恶刀客", 100, 6, 8,5,8, index);
                break;
            case 34:
                monster.initMonster("邪恶大法师", 100, 6, 8,5,8, index);
                break;
            case 35:
                monster.initMonster("猫头精", 100, 6, 8,5,8, index);
                break;
            case 36:
                monster.initMonster("骷髅大法师", 100, 6, 8,5,8, index);
                break;
            case 37:
                monster.initMonster("金甲守卫", 1000, 56, 8,5,8, index);
                break;
            case 38:
                monster.initMonster("土豪骷髅", 100, 6, 8,5,8, index);
                break;
            case 39:
                monster.initMonster("刀盾猪", 3000, 200, 180,200,150, index);
                break;
            case 40:
                monster.initMonster("红眼黄泡泡", 100, 6, 8,5,8, index);
                break;
            case 41:
                monster.initMonster("紫甲骷髅", 100, 6, 8,5,8, index);
                break;
            case 42:
                monster.initMonster("蝙蝠王", 100, 6, 8,5,8, index);
                break;
            case 43:
                monster.initMonster("黑石像头", 100, 6, 8,5,8, index);
                break;
            case 44:
                monster.initMonster("黑甲守卫", 100, 6, 8,5,8, index);
                break;
            case 45:
                monster.initMonster("黄甲守卫", 100, 6, 8,5,8, index);
                break;
            case 46:
                monster.initMonster("青甲守卫", 100, 6, 8,5,8, index);
                break;
            case 47:
                monster.initMonster("蓝甲将军", 100, 6, 8,5,8, index);
                break;
            case 48:
                monster.initMonster("巫师王", 100, 6, 8,5,8, index);
                break;
            case 49:
                monster.initMonster("红衣盗贼", 100, 6, 8,5,8, index);
                break;
            case 50:
                monster.initMonster("白鼻涕人", 100, 6, 8,5,8, index);
                break;
            case 51:
                monster.initMonster("毒兽人", 100, 6, 8,5,8, index);
                break;
            case 52:
                monster.initMonster("红甲守卫", 100, 6, 8,5,8, index);
                break;
            case 53:
                monster.initMonster("蓝甲守卫", 100, 6, 8,5,8, index);
                break;
            case 54:
                monster.initMonster("邪恶教皇", 100, 6, 8,5,8, index);
                break;
            case 55:
                monster.initMonster("白色泡泡", 60, 12, 8,5,8, index);
                break;
            case 56:
                monster.initMonster("十字军", 100, 6, 8,5,8, index);
                break;
            case 57:
                monster.initMonster("大地守卫", 100, 6, 8,5,8, index);
                break;
            case 58:
                monster.initMonster("火焰守卫", 100, 6, 8,5,8, index);
                break;
            case 59:
                monster.initMonster("邪恶傀儡", 100, 6, 8,5,8, index);
                break;
        }
        return monster;
    }
}
