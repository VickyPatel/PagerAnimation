package com.example.vickypatel.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by VickyPatel on 2016-03-11.
 */
public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

            view.setTranslationX(-1); //Half the normal speed

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }
}
