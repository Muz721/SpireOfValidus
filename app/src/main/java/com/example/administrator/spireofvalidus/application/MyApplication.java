package com.example.administrator.spireofvalidus.application;

import android.app.Application;

import com.example.administratop.spirefvalidus.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;



/**
 * Created by Administrator on 2017/7/7.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
