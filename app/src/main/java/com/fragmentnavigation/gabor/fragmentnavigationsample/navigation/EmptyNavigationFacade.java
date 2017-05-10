package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import java.lang.reflect.Type;

/**
 * A navigation facade without implementation to avoid the NullPointerException.
 */

public class EmptyNavigationFacade<T extends BaseActivity> extends BaseNavigationFacade<T> {


    @Override
    public boolean navigateTo(Type fragmentClass) {
        return false;
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle) {
        return false;
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return false;
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Object param, @AnimRes int enterAnimationID, @AnimRes int exitAnimationID) {
        return false;
    }

    @Override
    public boolean navigateTo(Type fragmentClass, Object param) {
        return false;
    }
}
