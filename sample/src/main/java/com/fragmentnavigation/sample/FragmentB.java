package com.fragmentnavigation.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;


public class FragmentB extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_b, null);

        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigator().navigateTo(FragmentC.class);
            }
        });
        return root;
    }

    @Override
    public boolean onBackPressed() {
        getNavigator().navigateTo(FragmentA.class);
        return true;
    }
}
