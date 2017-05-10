package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;


public abstract class FragmentActivity extends BaseActivity implements Interfaces.ActivityFragmentNavigation, Interfaces.OnCloseDrawer, Interfaces.NavigationFacadeInterface {

    BaseNavigationStrategy<BaseActivity> fragmentNavigationBehavior;
    private BaseNavigationFacade<BaseActivity> navigationFacade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigationBehavior = new StandardNavigationStrategy<>(getFragmentContainerID());
        navigationFacade = new NavigationFacade<>(this, fragmentNavigationBehavior);
    }

    /**
     * Returns the current focused fragment
     * @return currentFragment
     */
    @Override
    public BaseFragment getCurrentFragment() {
        return fragmentNavigationBehavior.currentFragment;
    }

    /**
     * Returns the fragment navigator
     * @return BaseNavigationFacade object
     */
    @Override
    @NonNull
    public BaseNavigationFacade getNavigator() {
        return navigationFacade == null ? navigationFacade = new EmptyNavigationFacade<>() : navigationFacade;
    }

    @Override
    public void onBackPressed() {
        if (!getCurrentFragment().onBackPressed()) super.onBackPressed();
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


