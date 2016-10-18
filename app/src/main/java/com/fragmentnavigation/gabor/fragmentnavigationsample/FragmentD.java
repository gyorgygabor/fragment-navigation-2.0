package com.fragmentnavigation.gabor.fragmentnavigationsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;


/**
 * Created by gyorgygabor on 21.09.2016.
 */

public class FragmentD extends BaseFragment {

    private static final String TAG = FragmentD.class.getSimpleName();

    private CustomBehavior customBehavior;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_d, null);


        if (customBehavior != null) {
            TextView textView = (TextView) root.findViewById(R.id.fragment_d_title);
            textView.setText(customBehavior.getCustomText());
        }

        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(FragmentA.class);
            }
        });

        return root;
    }


    public void setCustomBehavior(CustomBehavior behavior) {
        customBehavior = behavior;
    }

    @Override
    public boolean onBackPressed() {
        navigateTo(FragmentC.class);
        return true;
    }
}
