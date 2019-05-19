package com.linger.seepicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    Animation[] animations=new Animation[4];
    ViewFlipper flipper;
    final int distance=50;
    GestureDetector detector;
    private int[] images={R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,
            R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper=findViewById(R.id.fipper);
        detector=new GestureDetector(this,this);
        for (int i = 0; i <images.length; i++) {
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        animations[0]=AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        animations[1]=AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        animations[2]=AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        animations[3]=AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX()-e2.getX()>distance){
            flipper.setInAnimation(animations[2]);
            flipper.setOutAnimation(animations[1]);
            flipper.showPrevious();
            return true;
        }else if(e2.getX()-e1.getX()>distance){
            flipper.setInAnimation(animations[0]);
            flipper.setOutAnimation(animations[3]);
            flipper.showNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}
