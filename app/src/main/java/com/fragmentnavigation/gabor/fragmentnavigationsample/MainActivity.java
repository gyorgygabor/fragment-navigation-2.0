package com.fragmentnavigation.gabor.fragmentnavigationsample;

import android.os.Bundle;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.FragmentActivity;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNavigator().navigateTo(FragmentA.class);
    }

    @Override
    public int getFragmentContainerID() {
        return R.id.fragmentContainer;
    }
}
