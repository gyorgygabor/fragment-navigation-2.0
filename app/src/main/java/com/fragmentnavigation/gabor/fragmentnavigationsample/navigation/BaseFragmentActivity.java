package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
public abstract class BaseFragmentActivity extends BaseActivity implements Interfaces.ActivityFragmentNavigation, Interfaces.OnCloseDrawer {

    private static final String TAG = BaseFragmentActivity.class.getSimpleName();

    FragmentNavigationBehavior fragmentNavigationBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigationBehavior = new StandardFragmentNavigation();
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return fragmentNavigationBehavior.currentFragment;
    }


    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @return true if the navigation was success.
     **/
    public boolean navigateTo(Type fragmentClass) {
        return fragmentNavigationBehavior.navigateTo(this, getFragmentContainerID(), fragmentClass, null,0,0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @return true if the navigation was success.
     **/
    public boolean navigateTo(Type fragmentClass, Bundle bundle) {
        return fragmentNavigationBehavior.navigateTo(this, getFragmentContainerID(), fragmentClass, bundle,0,0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass    - your fragment instance or Class to navigate
     * @param bundle           - bundle to send to the fragment
     * @param enterAnimationID - your fragment`s enter animation
     * @param exitAnimationID  - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle, int enterAnimationID, int exitAnimationID) {
        return fragmentNavigationBehavior.navigateTo(this, getFragmentContainerID(), fragmentClass, bundle, enterAnimationID, exitAnimationID);
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



}


