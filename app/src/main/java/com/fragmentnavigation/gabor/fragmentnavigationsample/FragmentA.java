package com.fragmentnavigation.gabor.fragmentnavigationsample;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentA extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View root = inflater.inflate(R.layout.fragment_a, null);

        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFacade().navigateTo(new FragmentB());
            }
        });
        return root;
    }
}
