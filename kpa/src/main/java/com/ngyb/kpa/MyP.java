package com.ngyb.kpa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/11 20:52
 */
public class MyP extends View {
    private int f;
    private Paint paint;


    public MyP(Context context) {
        super(context);
        init();
    }

    public MyP(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyP(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (f < 40) {
            paint.setTextSize(20);
            paint.setColor(Color.GREEN);
        } else {
            paint.setTextSize(30);
            paint.setColor(Color.RED);
        }
        canvas.drawRect(50, 200 - f, 110, 200, paint);
        super.onDraw(canvas);
    }

    public void setP(int p){
        f = p;
        postInvalidate();
    }
}
