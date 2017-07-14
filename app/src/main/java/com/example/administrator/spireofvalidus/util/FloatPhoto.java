package com.example.administrator.spireofvalidus.util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/7/13.
 *
 */

public final class FloatPhoto implements Parcelable {
    public float left;
        public float top;
    public float right;
    public float bottom;
    protected FloatPhoto() {
    }

    protected FloatPhoto(Parcel in) {
        left = in.readFloat();
        top = in.readFloat();
        right = in.readFloat();
        bottom = in.readFloat();
    }

    public static final Creator<FloatPhoto> CREATOR = new Creator<FloatPhoto>() {
        @Override
        public FloatPhoto createFromParcel(Parcel in) {
            FloatPhoto floatPhoto=new FloatPhoto();
            floatPhoto.readFromParcel(in);
            return floatPhoto;
        }

        @Override
        public FloatPhoto[] newArray(int size) {
            return new FloatPhoto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(left);
        dest.writeFloat(top);
        dest.writeFloat(right);
        dest.writeFloat(bottom);
    }
//    public float left;
//    public float top;
//    public float right;
//    public float bottom;
//    protected FloatPhoto() {
//    }
//    protected FloatPhoto(Parcel in) {
//    }
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//
//    }
//}


    public void readFromParcel(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
    }

}

