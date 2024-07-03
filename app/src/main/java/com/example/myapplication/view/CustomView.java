package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomView extends View {

    String TAG = "MY_CUSTOM_VIEW ";
    Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
        System.out.println(TAG + "in 1 constructor");
        paint = new Paint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        System.out.println(TAG + "in 2 constructor");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        System.out.println(TAG + "in 3 constructor");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        System.out.println(TAG + "in 4 constructor");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        System.out.println(TAG + "in onAttachedToWindow");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        System.out.println(TAG + "in onMeasure");
    }

    @Override
    public void layout(int l, int t, int r, int b) {
//        super.layout(l, t, r, b);
        System.out.println(TAG + "in layout");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        layout(50, 100, right, bottom);
        System.out.println(TAG + "in onLayout");
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);
        System.out.println(TAG + "in dispatchDraw");
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        System.out.println(TAG + "in draw");
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        System.out.println(TAG + "in onDraw");
        paint.setColor(Color.RED);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        System.out.println(TAG + "in onDetachedFromWindow");
    }
}
