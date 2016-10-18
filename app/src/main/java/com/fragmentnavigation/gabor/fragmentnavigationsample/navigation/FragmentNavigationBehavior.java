package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.AnimRes;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
abstract class FragmentNavigationBehavior {

    public BaseFragment currentFragment;

    public abstract boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId);
}
