package com.bodrumlife.mobilesoft365;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.bodrumlife.mobilesoft365.FragmentBodRumLife.AboutBodRumFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.ConcertFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.ListBodRumFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.MainPlateFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.SplashScreenFragment;

/**
 * This is main activity
 * @author  BruSD
 * @version 1.0 28.08.13
 */
public class MyActivity extends FragmentActivity {
    /**
     * Runs fragment includes SplashScreenFragment
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

    /**
     * Runs fragment MainPlateFragment
     */
    public void comitMainPlateFragment(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new MainPlateFragment());
        ft.commit();

    }

    /**
     * Runs fragment AboutBodRumFragment
     */

    public void comitAboutBodRum(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new AboutBodRumFragment());
        ft.commit();
    }

    /**
     * Runs fragment ListBodRumFragment with value for shopping
     * @param listId int value of Enumeration_Bodrum
     */

    public void comitListBodRumFragment(int listId){
        Fragment fragment = new ListBodRumFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("catID", listId);
        fragment.setArguments(bundle);

        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, fragment);
        ft.commit();
    }

    /**
     * Runs fragment ConcertFragment
     */
    public void comitConcert(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new ConcertFragment());
        ft.commit();
    }
}
