package com.fragmentnavigation.gabor.fragmentnavigationsample;

import android.os.Bundle;
import android.support.annotation.AnimRes;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragmentActivity;

import java.lang.reflect.Type;


public class MainActivity extends BaseFragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNavigationFacade().navigateTo(FragmentA.class);
    }


    @Override
    public int getFragmentContainerID() {
        return R.id.fragmentContainer;
    }


}
