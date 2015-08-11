package com.example.navin.viewpagersample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Navin on 10/8/15.
 */

public class MyPagerAdapter extends PagerAdapter {
    private ArrayList<LinearLayout> arry;
    Context context;

    public MyPagerAdapter(Context context) {
        this.context = context;
        arry = new ArrayList<LinearLayout>();
        arry.add(new LinearLayout(context));
        arry.add(new LinearLayout(context));
        arry.add(new LinearLayout(context));
    }

    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }

    @Override
    public void destroyItem(ViewGroup view, int arg1, Object object) {
        ((ViewPager) view).removeView((LinearLayout) object);
    }

    @Override
    public int getCount() {
        return arry.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {

        View v = new View(context.getApplicationContext());

        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (position) {
            case 0:
                v = inflater.inflate(R.layout.jaw, null, false);
                break;
            case 1:
                v = inflater.inflate(R.layout.hello, null, false);
                break;
            case 2:
                v = inflater.inflate(R.layout.jaw, null, false);
            default:


                break;
        }
        ((ViewPager) view).addView(v, 0);

        return v;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}
