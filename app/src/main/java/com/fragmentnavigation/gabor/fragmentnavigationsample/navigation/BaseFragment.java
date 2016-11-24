package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;

import java.lang.reflect.Type;


/**
 * Created by gyorgygabor on 10.12.2015.
 */

public abstract class BaseFragment extends Fragment implements Type, Interfaces.OnBackPressed {

    protected Interfaces.FragmentNavigation fragmentNavigator;
    protected Interfaces.OnCloseDrawer drawerInterface;
    protected Activity context;
    protected Object mParam;

    private NavigationFacade navigationFacade;

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


        navigationFacade = new NavigationFacade(fragmentNavigator);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (drawerInterface != null) {
            drawerInterface.onCloseDrawer();
        }
    }


    public void setmParam(Object o) {
        mParam = o;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        fragmentNavigator = null;
        drawerInterface = null;
        navigationFacade = null;
    }

    @NonNull
    public NavigationFacade getNavigationFacade() {
        return navigationFacade == null ? navigationFacade = new NavigationFacade(fragmentNavigator) : navigationFacade;
    }
}
