package com.example.administrator.spireofvalidus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/6.
 */

public class BaseActivity extends AppCompatActivity {
    /**
     * 用于解除ButterKnife绑定
     */
    private Unbinder unbinder;
    protected void onCreate(Bundle savedInstanceState,int layoutResId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId);
        unbinder = ButterKnife.bind(this);
    }
    protected void onCreate(Bundle savedInstanceState,View view) {
        super.onCreate(savedInstanceState);
        setContentView(view);
        unbinder = ButterKnife.bind(this);
//        EventBus.getDefault().register(this);//订阅
    }
    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void finishStartActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
        this.finish();
    }
    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void finishTopStartActivity(Class<?> cls) {
        startActivity(new Intent(this, cls).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除ButterKnife绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
//        EventBus.getDefault().unregister(this);//解除订阅

    }
}
