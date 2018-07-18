package com.example.meituan.MyModule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 小薇 on 2018/7/17.
 */

public class Squar extends View{

    private Paint paint;

    public Squar(Context context) {
        super(context);
        init();
    }

    public Squar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Squar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        //初始化控件
        paint = new Paint();
        paint.setAntiAlias(true);
        //设置画笔样式
        paint.setStyle(Paint.Style.FILL);
        //设置粗细度
        paint.setStrokeWidth(5);
        //设置画笔的颜色
        paint.setColor(Color.argb(255,224,224,224));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect=new RectF(0,0,1500,40);
        canvas.drawRect(rect,paint);
    }
}
