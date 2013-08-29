package com.bodrumlife.mobilesoft365;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.bodrumlife.mobilesoft365.FragmentBodRumLife.MainPlateFragment;
import com.bodrumlife.mobilesoft365.FragmentBodRumLife.SplashScreenFragment;


public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        AsyncTaskForTwoItems asyncTaskForTwoItems = new AsyncTaskForTwoItems(this);
//        int value=AsyncTaskEnumeration.TypeOfAsyncTask.Hotels.getValue();
//        asyncTaskForTwoItems.execute(String.valueOf(value));
        AsyncTaskDetails asyncTaskForFourItems = new AsyncTaskDetails(this);
        int valeu=AsyncTaskEnumeration.TypeOfAsyncTask.Concerts.getValue();
        asyncTaskForFourItems.execute("2245",String.valueOf(valeu));
    }

    public void comitMainPlateFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frame_bod_rum, new MainPlateFragment());
        ft.commit();

    }


}
