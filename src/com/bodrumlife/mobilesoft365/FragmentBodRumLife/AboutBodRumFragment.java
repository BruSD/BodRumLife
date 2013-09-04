package com.bodrumlife.mobilesoft365.FragmentBodRumLife;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bodrumlife.mobilesoft365.MyActivity;
import com.bodrumlife.mobilesoft365.R;

/**
 * Runs AboutBodRumFragment
 * @author  BruSD
 * @version 1.0 29.08.13.
 */
public class AboutBodRumFragment extends Fragment {
    private Activity parentActivity;
    private View v;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_about_bod_rum, null);
        textView= (TextView) v.findViewById(R.id.right_text_about_post_scriptum);
        textView.setOnClickListener(new startMainFragment());
        return v;
           }

    class startMainFragment implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (parentActivity != null && parentActivity instanceof MyActivity)
                ((MyActivity)parentActivity).comitMainPlateFragment();
        }

    }



}
