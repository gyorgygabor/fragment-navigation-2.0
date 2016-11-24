package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.AnimRes;

import java.lang.reflect.Type;

/**
 * Created by Ani on 2016.11.24..
 */
public class NavigationFacade {


    private Interfaces.FragmentNavigation fragmentNavigator;

    public NavigationFacade(Interfaces.FragmentNavigation fragmentNavigator) {
        this.fragmentNavigator = fragmentNavigator;
    }


    private NavigationFacade(){

    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @return true if the navigation was success.
     **/

    public boolean navigateTo(Type fragmentClass) {
        return fragmentNavigator.navigateTo(fragmentClass, null, 0, 0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @return true if the navigation was success.
     **/


    public boolean navigateTo(Type fragmentClass, Bundle bundle) {
        return fragmentNavigator.navigateTo(fragmentClass, bundle, 0, 0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @param enterAnimId   - your fragment`s enter animation
     * @param exitAnimId    - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    public boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return fragmentNavigator.navigateTo(fragmentClass, bundle, enterAnimId, exitAnimId);
    }


    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param param        - param to send to the fragment
     * @param enterAnimationID   - your fragment`s enter animation
     * @param exitAnimationID    - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    public boolean navigateTo(Type fragmentClass, Object param, @AnimRes int enterAnimationID, @AnimRes int exitAnimationID) {
        return fragmentNavigator.navigateTo(fragmentClass, param, enterAnimationID, exitAnimationID);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param param        - param to send to the fragment
     * @return true if the navigation was success.
     **/
    public boolean navigateTo(Type fragmentClass, Object param) {
        return fragmentNavigator.navigateTo(fragmentClass, param,0,0);
    }

}
