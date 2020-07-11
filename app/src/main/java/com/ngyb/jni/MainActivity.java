package com.ngyb.jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FirstJniFile firstJniFile;
    private SecondJniFile secondJniFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstJniFile = new FirstJniFile();
        secondJniFile = new SecondJniFile();
    }

    public void click1(View view) {
        int add = firstJniFile.add(3, 4);
        Log.e(TAG, "click1: " + add);
        Toast.makeText(this, add + "", Toast.LENGTH_SHORT).show();
    }

    public void click2(View view) {
        String abcde = firstJniFile.sayHelloInC("abcde");
        Toast.makeText(this, abcde, Toast.LENGTH_SHORT).show();
    }

    public native void showToast();

    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void click3(View view) {
        int array[] = {1,2,3,4};
        int[] ints = firstJniFile.arrElementsIncrease(array);
        for (int anInt : ints) {
            Log.e(TAG, "click3: "+anInt );
        }
    }

    public void click4(View view) {
        secondJniFile.chello();
    }

    public void click5(View view) {
        secondJniFile.cadd();
    }

    public void click7(View view) {
        showToast();
    }

    public void click6(View view) {
        secondJniFile.cprintString();
    }
}
