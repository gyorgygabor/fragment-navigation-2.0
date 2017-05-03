package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.reflect.Type;


public abstract class BaseFragment extends Fragment implements Type, Interfaces.OnBackPressed {

    private static final String TAG = BaseFragment.class.getCanonicalName();
    protected Interfaces.OnCloseDrawer drawerInterface;
    protected Activity context;
    protected Object customParameter;

    private BaseNavigationFacade navigationFacade;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach() called with: context = [" + context + "]" + this);

        if (context instanceof Interfaces.OnCloseDrawer) {
            drawerInterface = (Interfaces.OnCloseDrawer) context;
        }

        if (!(context instanceof Interfaces.NavigationFacadeInterface)) {
            throw new ClassCastException();
        }

        navigationFacade = ((Interfaces.NavigationFacadeInterface) context).getNavigationFacade();
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
        Log.d(TAG, "onDetach() called");
        drawerInterface = null;
        navigationFacade = null;
    }

    @NonNull
    public BaseNavigationFacade getNavigationFacade() {
        return navigationFacade != null ? navigationFacade : new EmptyNavigationFacade();
    }
}
