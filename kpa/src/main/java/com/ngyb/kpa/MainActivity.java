package com.ngyb.kpa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ProgressBar pb;
    private MyP mp;
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        pb.setMax(100);
        mp = findViewById(R.id.mp);
    }

    public void start(View view) {
        new Thread() {
            @Override
            public void run() {
                begin();
            }
        }.start();
    }

    public native void begin();

    public void end(View view) {
        stop();
    }

    private native void stop();

    public void setP(int p) {
        Log.e(TAG, "setP: " + p);
        mp.setP(p);
    }
}
