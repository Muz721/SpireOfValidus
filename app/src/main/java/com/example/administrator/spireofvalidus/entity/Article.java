package com.example.administrator.spireofvalidus.entity;

import com.example.administrator.spireofvalidus.util.DataSynEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/7/10.
 */

public class Article {
    private String name;     //物品名称
    private int atk;         //增加攻击值
    private int def;         //增加防御值
    private int hp;          //增加HP
    private int goldKey;     //增加金钥匙
    private int silverKey;    //增加银钥匙
    private int copperKey;    //增加铜钥匙
    private int money;        //增加金币
    private int exp;          //增加经验
    private int level;       //增加等级
    private boolean isTSwp;    //是否是特殊物品
    private int articleIndex,articleRow,articleCol;     //物品所在二维数组
    private Article(){
    }
    private static Article article=null;
    public static Article getArticle(){
        if (article==null){
            article=new Article();
        }
        return article;
    }
    /** 物品 名称，攻击，防御，HP，黄钥匙，蓝钥匙，红钥匙, 金币，经验,是否特殊物品 */
    public void initArticle(String name,int atk, int def,int hp,int goldKey,int silverKey,int copperKey,int money,int exp,int level,boolean isTSwp){
        this.name=name;
        this.atk=atk;
        this.def=def;
        this.hp=hp;
        this.goldKey=goldKey;
        this.silverKey=silverKey;
        this.copperKey=copperKey;
        this.money=money;
        this.exp=exp;
        this.level=level;
        this.isTSwp=isTSwp;
    }
    public String getArticleNameStr(Player player){
        if (this.isTSwp){
            player.tsWpMap.put(this.name,"");
//            EventBus.getDefault().postSticky();
            return "恭喜获得 : 【"+this.name+"】";
        }
        if (this.atk>0){
            player.setAtk(player.getAtk()+this.atk);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getAtk(),10));
        }
        if (this.def>0){
            player.setDef(player.getDef()+this.def);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getDef(),11));
        }
        if (this.hp>0){
            player.setHp(player.getHp()+this.hp);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getHp(),9));
        }
        if (this.goldKey>0){
            player.setGoldKey(player.getGoldKey()+this.goldKey);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getGoldKey(),12));
        }
        if (this.silverKey>0){
            player.setSilverKey(player.getSilverKey()+this.silverKey);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getSilverKey(),13));
        }
        if (this.copperKey>0){
            player.setCopperKey(player.getCopperKey()+this.copperKey);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getCopperKey(),14));
        }
        if (this.money>0){
            player.setMoney(player.getMoney()+this.money);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getMoney(),15));
        }
        if (this.exp>0){
            player.setExp(player.getExp()+this.exp);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getExp(),15));
        }
        if (this.level>0){
            player.setLevel(player.getLevel()+this.level);
            EventBus.getDefault().postSticky(new DataSynEvent(""+player.getLevel(),15));
        }
        return "恭喜获得 : "+this.name;
    }
    public String getArticleInfo(){
        if (this.isTSwp){
            return "";
        }
        String info="增加:";
        info+=this.atk>0?"攻击"+this.atk+"!":"";
        info+=this.def>0?"防御"+this.def+"!":"";
        info+=this.hp>0?"HP"+this.hp+"!":"";
        info+=this.goldKey>0?"金钥匙"+this.goldKey+"!":"";
        info+=this.silverKey>0?"银钥匙"+this.silverKey+"!":"";
        info+=this.copperKey>0?"铜钥匙"+this.copperKey+"!":"";
        info+=this.money>0?"金币"+this.money+"!":"";
        info+=this.exp>0?"经验"+this.exp+"!":"";
        info+=this.level>0?"等级"+this.level+"!":"";
        return info;
    }
    //移除物品
    public boolean removeArticle(int [][] articleArr){
        if (articleArr[articleRow][articleCol]==articleIndex){
            articleArr[articleRow][articleCol]=0;
            return true;
        }else {
            return false;
        }
    }
    //获取物品在数组中的信息
    public void setArticleArrInfo(int index,int row,int col){
        this.articleIndex=index;
        this.articleRow=row;
        this.articleCol=col;
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

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getCopperKey() {
        return copperKey;
    }

    public void setCopperKey(int copperKey) {
        this.copperKey = copperKey;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isTSwp() {
        return isTSwp;
    }

    public void setTSwp(boolean TSwp) {
        isTSwp = TSwp;
    }

    public int getArticleIndex() {
        return articleIndex;
    }

    public void setArticleIndex(int articleIndex) {
        this.articleIndex = articleIndex;
    }

    public int getArticleRow() {
        return articleRow;
    }

    public void setArticleRow(int articleRow) {
        this.articleRow = articleRow;
    }

    public int getArticleCol() {
        return articleCol;
    }

    public void setArticleCol(int articleCol) {
        this.articleCol = articleCol;
    }

    public static void setArticle(Article article) {
        Article.article = article;
    }
}
