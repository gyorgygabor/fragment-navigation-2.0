package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.NonNull;

import java.lang.reflect.Type;


public abstract class BaseFragment extends Fragment implements Type, Interfaces.OnBackPressed {

    protected Interfaces.OnCloseDrawer drawerInterface;
    protected Activity context;
    protected Object customParameter;

    private BaseNavigationFacade navigationFacade;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        if (context instanceof Interfaces.OnCloseDrawer) {
            drawerInterface = (Interfaces.OnCloseDrawer) context;
        }

        if (!(context instanceof Interfaces.NavigationFacadeInterface)) {
            throw new ClassCastException();
        }

        navigationFacade = ((Interfaces.NavigationFacadeInterface) context).getNavigator();
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (drawerInterface != null) {
            drawerInterface.onCloseDrawer();
        }
    }

    public void setCustomParameter(Object o) {
        customParameter = o;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        drawerInterface = null;
        navigationFacade = null;
    }

    @NonNull
    public BaseNavigationFacade getNavigator() {
        return navigationFacade != null ? navigationFacade : new EmptyNavigationFacade();
    }
}
