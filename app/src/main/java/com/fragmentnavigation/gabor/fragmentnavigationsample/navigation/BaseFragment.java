package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.AnimRes;

import java.lang.reflect.Type;


/**
 * Created by gyorgygabor on 10.12.2015.
 */

public abstract class BaseFragment extends Fragment implements Type, Interfaces.FragmentNavigation, Interfaces.OnBackPressed {

    protected Interfaces.FragmentNavigation fragmentNavigator;
    protected Interfaces.OnCloseDrawer drawerInterface;
    protected Activity context;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        Activity activity = context;


        if (activity instanceof Interfaces.OnCloseDrawer) {
            drawerInterface = (Interfaces.OnCloseDrawer) activity;
        }

        if (!(activity instanceof Interfaces.FragmentNavigation)) {
            throw new ClassCastException();
        }

        fragmentNavigator = (Interfaces.FragmentNavigation) activity;
        this.context = activity;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (drawerInterface != null) {
            drawerInterface.onCloseDrawer();
        }
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @return true if the navigation was success.
     **/

    public boolean navigateTo(Type fragmentClass) {
        return fragmentNavigator.navigateTo(fragmentClass,null,0,0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @return true if the navigation was success.
     **/


    public boolean navigateTo(Type fragmentClass, Bundle bundle) {
        return fragmentNavigator.navigateTo(fragmentClass, bundle,0,0);
    }

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass    - your fragment instance or Class to navigate
     * @param bundle           - bundle to send to the fragment
     * @param enterAnimId - your fragment`s enter animation
     * @param exitAnimId  - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    @Override
    public boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId,@AnimRes int exitAnimId) {
       return fragmentNavigator.navigateTo(fragmentClass, bundle, enterAnimId, exitAnimId);
    }


    @Override
    public boolean onBackPressed() {
        return false;
    }
}
