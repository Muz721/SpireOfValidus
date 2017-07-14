package com.example.administrator.spireofvalidus.util;

import android.os.Parcel;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface MyParcelable {

    public static final int PARCELABLE_WRITE_RETURN_VALUE = 0x0001;


    public static final int PARCELABLE_ELIDE_DUPLICATES = 0x0002;


    public static final int CONTENTS_FILE_DESCRIPTOR = 0x0001;


    public int describeContents();

    public void writeToParcel(Parcel dest, int flags);

    public interface Creator<T> {

        public T createFromParcel(Parcel source);

        public T[] newArray(int size);
    }

    public interface ClassLoaderCreator<T> extends Creator<T> {

        public T createFromParcel(Parcel source, ClassLoader loader);
    }
}
