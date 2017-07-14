package com.example.administrator.spireofvalidus.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.administrator.spireofvalidus.BaseActivity;
import com.example.administrator.spireofvalidus.R;
import com.example.administrator.spireofvalidus.entity.Player;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/6.
 */

public class LoadingActivity extends BaseActivity implements Animation.AnimationListener {
    @BindView(R.id.storey)
    TextView storey;
Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View view = View.inflate(this, R.layout.activity_loading, null);
        super.onCreate(savedInstanceState, view);
//        EventBus.getDefault().register(this);//订阅
        init(view);
        player=Player.getPlayer(this);
        Log.e("-----",player.getMtStorey()+"");
        storey.setText(""+ player.getMtStorey()+"");
    }

    private void init(View view) {
        Animation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(2000);
        view.setAnimation(animation);
        animation.setAnimationListener(this);
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        finishTopStartActivity(GameActivity.class);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
