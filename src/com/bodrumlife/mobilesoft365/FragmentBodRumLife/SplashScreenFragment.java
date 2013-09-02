package com.bodrumlife.mobilesoft365.FragmentBodRumLife;


import android.app.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bodrumlife.mobilesoft365.AsyncTask.Enumeration_Bodrum;
import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskFourItems;
import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
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
        View v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_splash_screen_layout, null);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!DataStorage.isOnline(parentActivity)){
            final Dialog dialog = new Dialog(parentActivity);
            dialog.setContentView(R.layout.dialog_internet_connection);
            dialog.setTitle("Internet connection");
            TextView text = (TextView) dialog.findViewById(R.id.dialogText);
            text.setText("Turn on your Internet connection");
            Button dialogButton = (Button) dialog.findViewById(R.id.buttonDialog);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        else {
        new AsyncTaskFourItems(getActivity()).execute(String.valueOf(Enumeration_Bodrum.TypeOfAsyncTask.Events.getValue()));
       }
    }
}
