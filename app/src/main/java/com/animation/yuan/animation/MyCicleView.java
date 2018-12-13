package com.animation.yuan.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyCicleView extends View {
    private Point mPoint=new Point(30);

    public MyCicleView(Context context) {
        super(context);
    }

    public MyCicleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCicleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300, 300, mPoint.getmRadius(), paint);
        }
        super.onDraw(canvas);
    }

    void setPointRadius(int radius){
        mPoint.setmRadius(radius);
        invalidate();
    }

}
