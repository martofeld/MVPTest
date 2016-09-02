package com.mfeldsztejn.mvptest.main.behaviours;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.mfeldsztejn.mvptest.R;

/**
 * Created by mfeldsztejn on 8/28/16.
 */

public class PullUpBehaviour extends CoordinatorLayout.Behavior<LinearLayout> {
    public PullUpBehaviour() {
        super();
    }

    public PullUpBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
        return child.getId() == R.id.numbers_container;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
        if (dependency.getTranslationY() > 0) {
            float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
            child.setTranslationY(translationY);
            return true;
        } else {
            return false;
        }
    }
}
