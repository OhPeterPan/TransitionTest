package com.art.demo.transitiontest.custom;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

public class CustomColorTransition extends Transition {
    public static final String NAME = "com.art.demo.transitiontest:custom_color:backgroundColor";//命名格式  package_name:transition_name:property_name

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        if (transitionValues.view.getBackground() instanceof ColorDrawable)
            transitionValues.values.put(NAME, ((ColorDrawable) transitionValues.view.getBackground()).getColor());
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        if (transitionValues.view.getBackground() instanceof ColorDrawable)
            transitionValues.values.put(NAME, ((ColorDrawable) transitionValues.view.getBackground()).getColor());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        View view = endValues.view;


        int startColor = (int) startValues.values.get(NAME);

        int endColor = (int) endValues.values.get(NAME);

        ObjectAnimator animator = ObjectAnimator.ofArgb(view, "backgroundColor", startColor, endColor);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
