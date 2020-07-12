package com.ngyb.mtxx;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mt.mtxx.image.JNI;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Bitmap bitmap;
    private ImageView iv;
    private JNI jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(bitmap);
    }

    public void click(View view) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        jni = new JNI();
        jni.StyleBaoColor(pixels, width, height);
        Bitmap bitmap1 = Bitmap.createBitmap(pixels, width, height, bitmap.getConfig());
        iv.setImageBitmap(bitmap1);
    }
}
