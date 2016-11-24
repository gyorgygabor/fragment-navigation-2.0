package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.util.Log;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
public class StandardFragmentNavigation extends FragmentNavigationBehavior {



    @Override
    public boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Object param, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return navigationExecutor(context, fragmentContainerID, fragmentClass,null, param, enterAnimId, exitAnimId);
    }

    @Override
    public boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Bundle bundle, int enterAnimId, int exitAnimId) {
        return navigationExecutor(context, fragmentContainerID, fragmentClass,bundle, null, enterAnimId, exitAnimId);
    }

    private boolean navigationExecutor(Activity context, int fragmentContainerID, Type fragmentClass,Bundle bundle, Object param, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        currentFragment = (BaseFragment) context.getFragmentManager().findFragmentById(fragmentContainerID);
        BaseFragment targetFragment = getBaseFragmentFromType(fragmentClass);

        if (targetFragment != null && !isSameFragment(currentFragment,targetFragment)) {
            transaction(context, fragmentContainerID, bundle, param, targetFragment, enterAnimId, exitAnimId);
            return true;
        }
        return false;
    }

    private void transaction(Activity context, int fragmentContainerID, Bundle bundle, Object mParam, BaseFragment baseFragmentClass, int enterAnimId, int exitAnimId) {
        currentFragment = baseFragmentClass;


        if (mParam != null) {
            currentFragment.setmParam(mParam);
        }

        if (bundle != null) {
            currentFragment.setArguments(bundle);
        }

        FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

        if (enterAnimId > 0 && exitAnimId > 0) {
            transaction.setCustomAnimations(enterAnimId, exitAnimId);
        }

        transaction.replace(fragmentContainerID, currentFragment);
        transaction.commitAllowingStateLoss();
    }




}
