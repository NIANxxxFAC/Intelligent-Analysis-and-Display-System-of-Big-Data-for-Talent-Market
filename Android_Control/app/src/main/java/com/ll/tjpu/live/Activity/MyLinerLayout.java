package com.ll.tjpu.live.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinerLayout extends LinearLayout {
    private GestureDetector m_gestureDetector;

    public MyLinerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //设置为可点击
        setClickable(true);
        //2,初始化手势类，同时设置手势监听
        m_gestureDetector = new GestureDetector(context, onGestureListener);
        //双击监听-一般很少用到
        m_gestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //3,将touch事件交给gesture处理
        m_gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //初始化手势监听对象，使用GestureDetector.OnGestureListener的实现抽象类，因为实际开发中好多方法用不上
    private final GestureDetector.OnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("GestureDemoView", "onSingleTapUp() ");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d("GestureDemoView", "onLongPress() ");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("GestureDemoView", "onScroll() distanceX = " + distanceX);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("GestureDemoView", "onFling() velocityX = " + velocityX);
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d("GestureDemoView", "onShowPress() ");
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("GestureDemoView", "onDown() ");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("GestureDemoView", "onDoubleTap() ");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("GestureDemoView", "onDoubleTapEvent() ");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("GestureDemoView", "onSingleTapConfirmed() ");
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.d("GestureDemoView", "onContextClick() ");
            return super.onContextClick(e);
        }
    };
    private final GestureDetector.OnDoubleTapListener onDoubleTapListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("GestureDemoView", "onSingleTapConfirmed() OnDoubleTapListener");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("GestureDemoView", "onDoubleTap() OnDoubleTapListener");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("GestureDemoView", "onDoubleTapEvent() OnDoubleTapListener");
            return false;
        }
    };

}
