package com.example.administrator.spireofvalidus.manager;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

import com.example.administrator.spireofvalidus.R;

/**
 * Created by Administrator on 2017/7/6.
 */

public class SoundManager extends View{
    /**
     * 背景音乐
     */
    private static MediaPlayer mediaPlayerBackground=null;

    private static MediaPlayer mediaPlayerYinXiao = null; // 游戏音效

    // 初始化游戏音效、不提供get、set
    private static MediaPlayer actorgjMediaPlayer = null;// 玩家攻击
    private static MediaPlayer errorMediaPlayer = null;// 错误
    private static MediaPlayer guaiwugjMediaPlayer = null;// 怪物攻击
    private static MediaPlayer hdhpwpMediaPlayer = null;// 获得药品
    private static MediaPlayer hdwupinMediaPlayer = null;// 获得物品
    private static MediaPlayer kaidoorMediaPlayer = null;// 开门
    private static MediaPlayer sxloutiMediaPlayer = null;// 上下楼梯
    static Context context = null;
    public SoundManager(Context cont) {
        super(cont);
        context = cont;
        initSound();
    }

    private void initSound() {
        actorgjMediaPlayer = MediaPlayer.create(context, R.raw.actorgj);
        actorgjMediaPlayer.setLooping(false);
        errorMediaPlayer = MediaPlayer.create(context, R.raw.error);
        errorMediaPlayer.setLooping(false);
        guaiwugjMediaPlayer = MediaPlayer.create(context, R.raw.guaiwugj);
        guaiwugjMediaPlayer.setLooping(false);
        hdhpwpMediaPlayer = MediaPlayer.create(context, R.raw.hdhpwp);
        hdhpwpMediaPlayer.setLooping(false);
        hdwupinMediaPlayer = MediaPlayer.create(context, R.raw.hdwupin);
        hdwupinMediaPlayer.setLooping(false);
        kaidoorMediaPlayer = MediaPlayer.create(context, R.raw.kaidoor);
        kaidoorMediaPlayer.setLooping(false);
        sxloutiMediaPlayer = MediaPlayer.create(context, R.raw.sxlouti);
        sxloutiMediaPlayer.setLooping(false);
    }

    public static MediaPlayer getMediaPlayerBackground(){
        if (mediaPlayerBackground==null){
            mediaPlayerBackground=MediaPlayer.create(context, R.raw.backsound);
        }
        return mediaPlayerBackground;
    }
}
