package com.ngyb.jni;

import android.util.Log;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/11 15:14
 */
public class SecondJniFile {
    private static final String TAG = "SecondJniFile";

    /**
     * C调用java空方法
     */
    public void helloFromJava() {
        Log.e(TAG, "helloFromJava: ");
    }

    /**
     * C调用java中的带两个int参数的方法
     *
     * @param x
     * @param y
     * @return
     */
    public int add(int x, int y) {
        return x + y;
    }

    /**
     * C调用java中参数为String的方法
     *
     * @param s
     */
    public void printString(String s) {
        Log.e(TAG, "printString: " + s);
    }

    public native void chello();

    public native void cadd();

    public native void cprintString();
}
