package com.bodrumlife.mobilesoft365.DataBodRumLife;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BruSD on 29.08.13.
 */
public class DataStorage {

    private static List<HashMap<String, ?>> eventList = new ArrayList<HashMap<String, ?>>();


    public static void setEventList(List<HashMap<String, ?>> hashMaps){
        eventList = hashMaps;
    }

    public static List<HashMap<String, ?>> getEventList(){
        return eventList;
    }

    public static void clearEventList(){
       eventList = new ArrayList<HashMap<String, ?>>();
    }


    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

}
