package com.bodrumlife.mobilesoft365;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.bodrumlife.mobilesoft365.FragmentBodRumLife.AboutBodRumFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.MainPlateFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.SplashScreenFragment;
import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskDetails;
import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskEnumeration;
import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskForTwoItems;


public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    private  FragmentTransaction ft;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new SplashScreenFragment());
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void comitMainPlateFragment(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new MainPlateFragment());
        ft.commit();

    }

    public void comitAboutBodRum(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new AboutBodRumFragment());
        ft.commit();
    }


}
