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
    int Count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Count = 3;

        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
        vp.setCurrentItem(0);
        vp.setClipToPadding(false);
        vp.setPageMargin(12);

        buttonHolder = (LinearLayout) findViewById(R.id.dots_holder);

        addChild();

        MyPagerAdapter adapter = new MyPagerAdapter(this);
        vp.setAdapter(adapter);

        final TextView tvHeader = (TextView) findViewById(R.id.textViewHeader);
        tvHeader.setText("Page 1");

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                tvHeader.setText("Page " + (arg0 + 1));

                for (int i = 0; i < Count; i++) {
                    ImageView circle = (ImageView) buttonHolder.getChildAt(i);
                    if (i == arg0) {
                        circle.setColorFilter(getResources().getColor(R.color.text_selected));
                    } else {
                        circle.setColorFilter(getResources().getColor(android.R.color.transparent));
                    }
                }
            }

        });

    }

    private void addChild() {
        for (int i = 0; i < Count; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.ic_swipe_indicator_white_18dp);
            buttonHolder.addView(iv);
        }

        ImageView view1 = (ImageView) buttonHolder.getChildAt(0);
        view1.setColorFilter(getResources().getColor(R.color.text_selected));
    }

}
