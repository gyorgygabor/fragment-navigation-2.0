package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.AnimRes;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 14.10.2016.
 */


public class Interfaces {

    public interface OnCloseDrawer {
        void onCloseDrawer();
    }

    public interface OnBackPressed {
        boolean onBackPressed();
    }

    public interface FragmentNavigation {
        boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimationID, @AnimRes int exitAnimationID);
    }

    public interface ActivityFragmentNavigation extends FragmentNavigation {
        BaseFragment getCurrentFragment();
        int getFragmentContainerID();
    }
}