package com.bodrumlife.mobilesoft365.FragmentBodRumLife;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bodrumlife.mobilesoft365.R;

/**
 * Created by BruSD on 30.08.13.
 */
public class ListBodRumFragment extends Fragment {

    private Activity parentActivity = null;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_list_bod_rum, null);

        Bundle bundle = this.getArguments();
        int myInt = bundle.getInt("catID",0);
        TextView textView  = (TextView)v.findViewById(R.id.test_text);
        textView.setText(String.valueOf(myInt));


        return v;
    }
}
