package com.hqs.savaeye.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hqs.savaeye.R;
import com.hqs.savaeye.util.L;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/10.
 * 点随机显示在屏幕的任意一个位置
 */
public class RandomPoint extends View {

    /**
     * 点显示的三个等级，值越小越快
     */
    public static final long levelOne = 800;
    public static final long levelTwo = 600;
    public static final long levelThree = 300;

    /**
     * 当前的等级
     */
    private long currentLevel = levelOne;

    /**
     * 点的颜色
     */
    private int pointColor;

    /**
     * 点的大小
     */
    private float pointDimension;

    /**
     * 点的画笔
     */
    private Paint mPaint;

    /**
     * View的宽度
     */
    private int mWidth;

    /**
     * View的高度
     */
    private int mHeight;

    /**
     * 点的位置
     */
    private int pointX;
    private int pointY;

    private Random random = new Random();
    private final String clickStart = "点击屏幕任意处开始";

    private Rect textRect = new Rect();

    /**
     * 是否开始移动
     */
    private boolean isStart = false;

    /**
     * 文字的画笔
     */
    private Paint mPaintText;
    private Handler mHander = new Handler(){};

    /**
     * 点移动的Runnable
     */
    private Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {
            generateRandomNum();
            mHander.postDelayed(moveRunnable,currentLevel);
        }
    };

    public RandomPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RandomPoint(Context context) {
        super(context);
        init(context,null);
    }

    /**
     * 初始化
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.RandomPoint);
        pointColor = ta.getColor(R.styleable.RandomPoint_pointcolor, Color.BLUE);
        pointDimension = ta.getDimension(R.styleable.RandomPoint_pointsize, 21);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(pointColor);

        mPaintText = new Paint();
        mPaintText.setTextSize(36);
        mPaintText.getTextBounds(clickStart,0,clickStart.length(),textRect);
        mPaintText.setColor(Color.WHITE);
    }


    /**
     * 获取View的宽高
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        pointX = mWidth/2;
        pointY = mHeight/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        canvas.drawCircle(pointX,pointY,pointDimension,mPaint);

        if(!isStart){
            canvas.drawText(clickStart,mWidth/2-textRect.width()/2,mHeight/2,mPaintText);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                L.e("TouchDOWN");
                isStart = !isStart;
                if(isStart){
                    mHander.post(moveRunnable);
                }else{
                    stop();
                }
                break;

        }

        return super.onTouchEvent(event);
    }

    /**
     * 在屏幕上生成随机的点
     */
    public void generateRandomNum(){
            int randomWidth = random.nextInt(mWidth);
            int randomHeight = random.nextInt(mHeight);
            pointX = randomWidth;
            pointY = randomHeight;
            L.e("pointX="+pointX);
            L.e("pointY="+pointY);
            postInvalidate();
    }

    /**
     * 停止生成随机点
     */
    public void stop(){
        isStart = false;
        mHander.removeCallbacks(moveRunnable);
        invalidate();
    }

    /**
     * 设置等级
     * @param level
     */
    public void setLevel(long level){
        this.currentLevel = level;
        isStart = true;
        mHander.post(moveRunnable);
    }



}
