package com.bodrumlife.mobilesoft365.FragmentBodRumLife;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bodrumlife.mobilesoft365.R;

/**
 * Created by BruSD on 29.08.13.
 */
public class AboutBodRumFragment extends Fragment {
    private Activity parentActivity;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_about_bod_rum, null);

        return v;
    }
}
