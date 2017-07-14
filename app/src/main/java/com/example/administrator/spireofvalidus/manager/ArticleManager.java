package com.example.administrator.spireofvalidus.manager;

import com.example.administrator.spireofvalidus.entity.Article;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ArticleManager {
    public static final String PICKMATTOCK="铁镐";
    public static final String CROSS="十字架";
    public static final String HEXAGRAM="六角星阵";
    public static Article getArticle(int articleIndex){
        Article article=Article.getArticle();
        switch (articleIndex){
            case 13:
                article.initArticle("红宝石", 3, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 1:
                article.initArticle("蓝宝石", 0, 3, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 2:
                article.initArticle("绿宝石", 6, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 3:
                article.initArticle("黄宝石", 0, 6, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 4:
                article.initArticle("小营养液",0, 0, 200, 0, 0, 0, 0,0, 0, false);
                break;
            case 5:
                article.initArticle("中营养液",0, 0, 500, 0, 0, 0, 0, 0,0, false);
                break;
            case 6:
                article.initArticle("大营养液", 0, 0, 800, 0, 0, 0, 0, 0,0, false);
                break;
            case 7:
                article.initArticle("超大营养液",0, 0, 1500, 0, 0, 0, 0, 0,0, false);
                break;
            case 14:
                article.initArticle("智慧水壶",0, 0, 0, 0, 0, 0, 0, 100,0, false);
                break;
            case 15:
                article.initArticle("大智慧水壶", 0, 0, 0, 0, 0, 0, 0, 200,0, false);
                break;
            case 16:
                article.initArticle("金钥匙",0, 0, 0, 1, 0, 0, 0, 0,0, false);
                break;
            case 17:
                article.initArticle("银钥匙", 0, 0, 0, 0, 1, 0, 0, 0,0, false);
                break;
            case 18:
                article.initArticle("铜钥匙", 0, 0, 0, 0, 0, 1, 0, 0,0, false);
                break;
            case 22:
                article.initArticle("钥匙盒",0, 0, 0, 1, 1, 1, 0, 0,0, false);
                break;
            case 28:
                article.initArticle("智慧之书",0, 0, 0, 0, 0, 0, 0, 300,0, false);
                break;
            case 30:
                article.initArticle(HEXAGRAM, 0, 0, 0, 0, 0, 0, 0, 0,0, true);
                break;
            case 31:
                article.initArticle("笑脸币",0, 0, 0, 0, 0, 0, 100, 0,0, false);
                break;
            case 33:
                article.initArticle(PICKMATTOCK,0, 0, 0, 0, 0, 0, 0, 0,0, true);
                break;
            case 36:
                article.initArticle("飞行翼", 0, 0, 0, 0, 0, 0, 0, 0,1, false);
                break;
            case 38:
                article.initArticle("大飞行翼",0, 0, 0, 0, 0, 0, 0, 0,3, false);
                break;
            case 39:
                article.initArticle(CROSS, 0, 0, 0, 0, 0, 0, 0, 0,0, true);
                break;
            case 45:
                article.initArticle("新年福袋",20, 0, 2000, 0, 0, 0, 0, 0,0, false);
                break;
            case 48:
                article.initArticle("铁剑", 5, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 49:
                article.initArticle("钢剑",15, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 50:
                article.initArticle("大铁剑",30, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 51:
                article.initArticle("大钢剑",50, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 52:
                article.initArticle("英雄剑",100, 0, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 56:
                article.initArticle("皮盾", 0, 5, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 57:
                article.initArticle("木盾",0, 12, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 58:
                article.initArticle("铁盾",0, 25, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 59:
                article.initArticle("宝石盾",0, 50, 0, 0, 0, 0, 0, 0,0, false);
                break;
            case 60:
                article.initArticle("英雄盾", 0,100, 0, 0, 0, 0, 0, 0,0, false);
                break;
        }
        return article;
    }
}
