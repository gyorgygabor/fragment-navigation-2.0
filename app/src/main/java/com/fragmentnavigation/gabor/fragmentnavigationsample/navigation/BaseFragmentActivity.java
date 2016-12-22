package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;


public abstract class BaseFragmentActivity extends BaseActivity implements Interfaces.ActivityFragmentNavigation, Interfaces.OnCloseDrawer, Interfaces.NavigationFacadeInterface {

    BaseFragmentNavigationStrategy<BaseActivity> fragmentNavigationBehavior;
    private BaseNavigationFacade<BaseActivity> navigationFacade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigationBehavior = new StandardFragmentNavigationStrategy<>(getFragmentContainerID());
        navigationFacade = new NavigationFacade<>(this, fragmentNavigationBehavior);
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return fragmentNavigationBehavior.currentFragment;
    }

    @Override
    @NonNull
    public BaseNavigationFacade getNavigationFacade() {
        return navigationFacade == null ? navigationFacade = new EmptyNavigationFacade<>() : navigationFacade;
    }

    @Override
    public void onBackPressed() {
        if (!getCurrentFragment().onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void onCloseDrawer() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigationFacade = null;
        fragmentNavigationBehavior = null;
    }
}


