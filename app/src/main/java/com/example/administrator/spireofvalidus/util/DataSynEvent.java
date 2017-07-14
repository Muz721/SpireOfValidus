package com.example.administrator.spireofvalidus.util;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DataSynEvent {
    private int count;
    private String message;

    /**
     * @param uid UID
     */
    public DataSynEvent(String uid,int count) {
        this.message=uid;
        this.count=count;
    }

    public int getCount() {
        return count;
    }
    public String getUid(){
        return message;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
