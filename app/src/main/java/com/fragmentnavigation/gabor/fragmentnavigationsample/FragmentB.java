package com.fragmentnavigation.gabor.fragmentnavigationsample;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentB extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_b, null);
        super.onCreateView(inflater, container, savedInstanceState);


        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFacade().navigateTo(FragmentC.class);
            }
        });

        return root;
    }




    @Override
    public boolean onBackPressed() {
        getNavigationFacade().navigateTo(FragmentA.class);
        return true;
    }
}
