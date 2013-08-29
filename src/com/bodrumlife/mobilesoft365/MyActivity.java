package com.bodrumlife.mobilesoft365;

import android.app.Activity;
import android.os.Bundle;

import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskDetails;
import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskEnumeration;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
