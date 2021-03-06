package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * 带颜色渐变和缩放的指示器标题
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {
    private float mMinScale = 0.75f;
    private Interpolator mStartInterpolator = new LinearInterpolator();

    public ScaleTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override
    public void onLeave(int index, float offset, boolean leftToRight) {
        super.onLeave(index, offset, leftToRight);
        setScaleX(1.0f + (mMinScale - 1.0f) * mStartInterpolator.getInterpolation(offset));
        setScaleY(1.0f + (mMinScale - 1.0f) * offset);
    }

    @Override
    public void onEnter(int index, float offset, boolean leftToRight) {
        super.onEnter(index, offset, leftToRight);
        setScaleX(mMinScale + (1.0f - mMinScale) * mStartInterpolator.getInterpolation(offset));
        setScaleY(mMinScale + (1.0f - mMinScale) * mStartInterpolator.getInterpolation(offset));
    }

    public float getMinScale() {
        return mMinScale;
    }

    public void setMinScale(float minScale) {
        mMinScale = minScale;
    }

    public Interpolator getStartInterpolator() {
        return mStartInterpolator;
    }

    public void setStartInterpolator(Interpolator startInterpolator) {
        mStartInterpolator = startInterpolator;
        if (mStartInterpolator == null) {
            mStartInterpolator = new LinearInterpolator();
        }
    }
}
