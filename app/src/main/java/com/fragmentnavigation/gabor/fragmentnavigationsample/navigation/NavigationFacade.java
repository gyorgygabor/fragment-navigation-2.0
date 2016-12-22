package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import java.lang.reflect.Type;


public class NavigationFacade<T extends BaseActivity> extends BaseNavigationFacade<T> {


    NavigationFacade(T activity, BaseFragmentNavigationStrategy<T> navigationStrategy) {
        this.fragmentNavigationStrategy = navigationStrategy;
        this.activity = activity;
    }


    private NavigationFacade() {
    }


    @Override
    public boolean navigateTo(Type fragmentClass) {
        return fragmentNavigationStrategy != null && fragmentNavigationStrategy.navigateTo(activity, fragmentClass, null, 0, 0);
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle) {
        return fragmentNavigationStrategy != null && fragmentNavigationStrategy.navigateTo(activity, fragmentClass, bundle, 0, 0);
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return fragmentNavigationStrategy != null && fragmentNavigationStrategy.navigateTo(activity, fragmentClass, bundle, enterAnimId, exitAnimId);
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Object param, @AnimRes int enterAnimationID, @AnimRes int exitAnimationID) {
        return fragmentNavigationStrategy != null && fragmentNavigationStrategy.navigateTo(activity, fragmentClass, param, enterAnimationID, exitAnimationID);
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Object param) {
        return fragmentNavigationStrategy != null && fragmentNavigationStrategy.navigateTo(activity, fragmentClass, param, 0, 0);
    }

}
