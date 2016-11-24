package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.util.Log;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
abstract class FragmentNavigationBehavior {

    private static final String TAG = StandardFragmentNavigation.class.getSimpleName();

    public BaseFragment currentFragment;

    protected BaseFragment getBaseFragmentFromType(Type fragmentClass) {
        BaseFragment baseFragment = null;
        if (fragmentClass instanceof BaseFragment) {
            baseFragment = (BaseFragment) fragmentClass;
        } else {
            try {
                Class<? extends BaseFragment> baseFragmentClass = (Class<BaseFragment>) fragmentClass;
                baseFragment = baseFragmentClass.newInstance();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
                // return false;
            }
        }
        return baseFragment;
    }

    protected boolean isSameFragment(BaseFragment currentFragment, BaseFragment targetFragment) {
        return targetFragment.getClass().isInstance(currentFragment);
    }

    public abstract boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId);
    public abstract boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Object param, @AnimRes int enterAnimId, @AnimRes int exitAnimId);
}
