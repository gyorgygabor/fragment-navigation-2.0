package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;


import android.app.FragmentTransaction;
import android.os.Bundle;


public class StandardFragmentNavigationStrategy<T extends BaseActivity> extends BaseFragmentNavigationStrategy<T> {


    public StandardFragmentNavigationStrategy(int fragmentContainerID) {
        super(fragmentContainerID);
    }




    @Override
    void transaction(T context, Bundle bundle, Object mParam, BaseFragment baseFragmentClass, int enterAnimId, int exitAnimId) {
        currentFragment = baseFragmentClass;

        if (mParam != null) {
            currentFragment.setCustomParameter(mParam);
        }

        if (bundle != null) {
            currentFragment.setArguments(bundle);
        }


        FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

        if (enterAnimId > 0 && exitAnimId > 0) {
            transaction.setCustomAnimations(enterAnimId, exitAnimId);
        }

        transaction.replace(fragmentContainerId, currentFragment);
        transaction.commitAllowingStateLoss();
    }
}
