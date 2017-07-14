package com.example.administrator.spireofvalidus;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.spireofvalidus.main.LoadingActivity;
import com.example.administrator.spireofvalidus.manager.MyBitMapManager;
import com.example.administrator.spireofvalidus.manager.SoundManager;
import com.example.administrator.spireofvalidus.util.BitmapUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.new_game)
    TextView newGame;
    @BindView(R.id.music_switch)
    TextView musicSwitch;
    @BindView(R.id.exit)
    TextView exit;
    //背景音乐
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BitmapUtils.init(this);
        super.onCreate(savedInstanceState, R.layout.activity_main);
        new SoundManager(this);
        mediaPlayer = SoundManager.getMediaPlayerBackground();
        if (mediaPlayer.isPlaying()){
            musicSwitch.setText(""+"音乐:OFF"+"");
        }
        new MyBitMapManager(this).initBitMap();
//        EventBus.getDefault().postSticky(new DataSynEvent("ssss",1));
    }


    @OnClick({R.id.new_game, R.id.music_switch, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.new_game:
                startActivity(LoadingActivity.class);
                break;
            case R.id.music_switch:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    musicSwitch.setText(""+"音乐:ON"+"");
                }else {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    musicSwitch.setText(""+"音乐:OFF"+"");
                }
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}
