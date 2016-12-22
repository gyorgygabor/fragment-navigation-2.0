package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;


class Interfaces {

    interface OnCloseDrawer {
        void onCloseDrawer();
    }

    interface OnBackPressed {
        boolean onBackPressed();
    }

    interface ActivityFragmentNavigation {
        BaseFragment getCurrentFragment();
        int getFragmentContainerID();
    }

    interface NavigationFacadeInterface {
        BaseNavigationFacade getNavigationFacade();
    }
}