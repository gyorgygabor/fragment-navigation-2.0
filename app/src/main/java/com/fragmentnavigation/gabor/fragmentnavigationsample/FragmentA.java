package com.fragmentnavigation.gabor.fragmentnavigationsample;

import com.fragmentnavigation.gabor.fragmentnavigationsample.navigation.BaseFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by gyorgygabor on 21.09.2016.
 */

public class FragmentA extends BaseFragment {


    private static final String TAG = FragmentA.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_a, null);


        root.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick() called with: " + "v = [" + v + "]");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                Log.d(TAG, "onClick() called with: " + "v = [" + v + "]");
                getNavigationFacade().navigateTo(new FragmentB());
            }
        });


        return root;
    }
}
