package com.bodrumlife.mobilesoft365.FragmentBodRumLife;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bodrumlife.mobilesoft365.R;

/**
 * Created by BruSD on 28.08.13.
 */
public class SplashScreenFragment extends Fragment {
    private Activity parentActivity = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        View v = LayoutInflater.from(parentActivity).inflate(R.layout.splash_screen_layout, null);

        return v;
    }
}
