package com.ngyb.jnihelloworld;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/10 09:55
 */
public class FirstJniFile {
    static {
        System.loadLibrary("FirstJniFile");
    }

    public static native String helloWorld();
}
