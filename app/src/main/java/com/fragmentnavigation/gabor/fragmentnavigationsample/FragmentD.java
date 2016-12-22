package com.fragmentnavigation.gabor.fragmentnavigationsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;


public class FragmentD extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_d, null);


        if (customParameter != null && customParameter instanceof CustomBehavior) {
            TextView textView = (TextView) root.findViewById(R.id.fragment_d_title);
            textView.setText(((CustomBehavior)customParameter).getCustomText());
        }

        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFacade().navigateTo(FragmentA.class);
            }
        });

        return root;
    }




    @Override
    public boolean onBackPressed() {
        getNavigationFacade().navigateTo(FragmentC.class);
        return true;
    }
}
