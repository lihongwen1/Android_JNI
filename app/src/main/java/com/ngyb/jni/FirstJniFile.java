package com.ngyb.jni;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/11 15:09
 */
public class FirstJniFile {
    static{
        System.loadLibrary("native-lib");
    }

    public native int add(int x, int y);

    public native String sayHelloInC(String s);

    public native int[] arrElementsIncrease(int[] intArray);
}
