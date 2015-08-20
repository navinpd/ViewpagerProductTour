package com.example.navin.viewpagersample;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    LinearLayout buttonHolder;
    int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
        buttonHolder = (LinearLayout) findViewById(R.id.dots_holder);

        addChild();

        MyPagerAdapter adapter = new MyPagerAdapter(this, count);

        vp.setPageMargin(30);
//        vp.setMotionEventSplittingEnabled(true);
        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highlightPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final TextView tvHeader = (TextView) findViewById(R.id.textViewHeader);
        tvHeader.setText("Page 1");

    }

    private void highlightPage(int position) {
        if (position < count)
            for (int i = 0; i < count; i++) {
                ImageView circle = (ImageView) buttonHolder.getChildAt(i);
                if (i == position) {
                    circle.setColorFilter(getResources().getColor(R.color.text_selected));
                } else {
                    circle.setColorFilter(getResources().getColor(android.R.color.transparent));
                }
            }
    }

    private void addChild() {
        for (int i = 0; i < count; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.ic_swipe_indicator_white_18dp);
            buttonHolder.addView(iv);
        }
        highlightPage(0);

    }

}
