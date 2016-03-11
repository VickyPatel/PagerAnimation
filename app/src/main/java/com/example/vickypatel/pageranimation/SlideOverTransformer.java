package com.example.vickypatel.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by VickyPatel on 2016-03-11.
 */
public class SlideOverTransformer implements ViewPager.PageTransformer{

    private static final float MIN_SCALE_DEPTH = 0.75f;
    private static final float MIN_SCALE_ZOOM = 0.85f;
    private static final float MIN_ALPHA_ZOOM = 0.5f;
    private static final float SCALE_FACTOR_SLIDE = 0.85f;
    private static final float MIN_ALPHA_SLIDE = 0.35f;


    @Override
    public void transformPage(View page, float position) {
        final float alpha;
        final float scale;
        final float translationX;

        if (position < 0 && position > -1) {
            // this is the page to the left
            scale = Math.abs(Math.abs(position) - 1) * (1.0f - SCALE_FACTOR_SLIDE) + SCALE_FACTOR_SLIDE;
            alpha = Math.max(MIN_ALPHA_SLIDE, 1 - Math.abs(position));
            int pageWidth = page.getWidth();
            float translateValue = position * -pageWidth;
            if (translateValue > -pageWidth) {
                translationX = translateValue;
            } else {
                translationX = 0;
            }
        } else {
            alpha = 1;
            scale = 1;
            translationX = 0;
        }

        page.setAlpha(alpha);
        page.setTranslationX(translationX);
        page.setScaleX(scale);
        page.setScaleY(scale);
    }
}
