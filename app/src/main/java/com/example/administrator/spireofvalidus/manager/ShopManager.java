package com.example.administrator.spireofvalidus.manager;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ShopManager {
    public static String[] shopTitle;
    public static int[] BuffVale;
    public static int[] XHValue;
    public static void getShopInfo(int shopIndex){
        switch (shopIndex){
            case 2:
                shopTitle =new String[]{"    相信你一定有特殊的需--要，只要你有金币，我就--可以帮你。",
                        "购买 1 把黄钥匙（$10）","购买 1 把蓝钥匙（$50）","购买 1 把红钥匙（$50）","离开商店"};
                BuffVale=new int[]{1,1,1};
                XHValue=new int[]{10,50,100};
                break;
            case 3:
                shopTitle =new String[]{"    想要增加你的能力吗？--如果你有 100 个金币，--你可以任意选择一项。",
                        "增加 4000 点生命","增加 20 点攻击","增加 20 点防御","离开商店"};
                BuffVale=new int[]{4000,20,20};
                XHValue=new int[]{100,100,100};
                break;
            case 4:
                shopTitle =new String[]{"    你好，英雄的人类，只--要你有足够的经验，我就--可以让你变得更强大。",
                        "提升一级（需要消耗100点）","增加攻击5 （需要30点）","增加防御5（需要30点）","离开商店"};
                BuffVale=new int[]{1,5,5};
                XHValue=new int[]{100,30,30};
                break;
            case 5:
                shopTitle =new String[]{"    想要增加你的能力吗？--如果你有 25 个金币，--你可以任意选择一项。",
                        "增加 800 点生命","增加 4 点攻击","增加 4 点防御","离开商店"};
                BuffVale=new int[]{800,4,4};
                XHValue=new int[]{25,25,25};
                break;
        }
    }
}
