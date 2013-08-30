package com.bodrumlife.mobilesoft365.FragmentBodRumLife;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;


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
        v = LayoutInflater.from(parentActivity).inflate(R.layout.if_you_on_bodrumlife, null);
        LinearLayout ln = (LinearLayout)v.findViewById(R.id.liner_opacity);
        AlphaAnimation alpha = new AlphaAnimation(0.5F, 0.5F);
        alpha.setDuration(0);
        alpha.setFillAfter(true);
        ln.startAnimation(alpha);

//        int opacity = 127;
//        ln.setAlpha(opacity);
        return v;
           }

}
