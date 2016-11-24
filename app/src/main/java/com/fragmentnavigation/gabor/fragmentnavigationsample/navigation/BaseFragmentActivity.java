package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;

import java.lang.reflect.Type;

/**
 * Created by gyorgygabor on 19.08.2016.
 */
public abstract class BaseFragmentActivity extends BaseActivity implements Interfaces.ActivityFragmentNavigation, Interfaces.OnCloseDrawer {

    private static final String TAG = BaseFragmentActivity.class.getSimpleName();

    FragmentNavigationBehavior fragmentNavigationBehavior;
    private NavigationFacade navigationFacade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigationBehavior = new StandardFragmentNavigation();
        navigationFacade = new NavigationFacade(this);
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return fragmentNavigationBehavior.currentFragment;
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

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass    - your fragment instance or Class to navigate
     * @param param           - param to send to the fragment
     * @param enterAnimationID - your fragment`s enter animation
     * @param exitAnimationID  - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    @Override
    public boolean navigateTo(Type fragmentClass, Object param, int enterAnimationID, int exitAnimationID) {
        return fragmentNavigationBehavior.navigateTo(this, getFragmentContainerID(), fragmentClass, param, enterAnimationID, exitAnimationID);
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


    @NonNull
    public NavigationFacade getNavigationFacade() {
        return navigationFacade == null ? navigationFacade = new NavigationFacade(this) : navigationFacade;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigationFacade = null;
        fragmentNavigationBehavior= null;
    }
}


