package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
public class StandardFragmentNavigation extends FragmentNavigationBehavior {


    private static final String TAG = StandardFragmentNavigation.class.getSimpleName();


    @Override
    public boolean navigateTo(Activity context, int fragmentContainerID, Type fragmentClass, Bundle bundle, int enterAnimId, int exitAnimId) {
        currentFragment = (BaseFragment) context.getFragmentManager().findFragmentById(fragmentContainerID);

        if (fragmentClass instanceof BaseFragment) {
            BaseFragment baseFragmentClass = (BaseFragment) fragmentClass;


            if (!baseFragmentClass.getClass().isInstance(currentFragment)) {
                navigate(context, fragmentContainerID, bundle, baseFragmentClass,enterAnimId,exitAnimId);
                return true;
            }
        } else {
            try {
                Class<BaseFragment> baseFragmentClass = (Class<BaseFragment>) fragmentClass;
                if (!baseFragmentClass.isInstance(currentFragment)) {
                    navigate(context, fragmentContainerID, bundle, baseFragmentClass.newInstance(), enterAnimId, exitAnimId);
                    return true;
                }
            } catch (Exception e) {
                //your handling here
                Log.e(TAG, e.getMessage(), e);
            }
        }

        return false;
    }

    private void navigate(Activity context, int fragmentContainerID, Bundle bundle, BaseFragment baseFragmentClass, int enterAnimId, int exitAnimId) {
        currentFragment = baseFragmentClass;

        if (bundle != null) {
            currentFragment.setArguments(bundle);
        }

        FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

        if(enterAnimId > 0 && exitAnimId > 0) {
            transaction.setCustomAnimations(enterAnimId, exitAnimId);
        }

        transaction.replace(fragmentContainerID, currentFragment);
        transaction.commitAllowingStateLoss();

    }

}
