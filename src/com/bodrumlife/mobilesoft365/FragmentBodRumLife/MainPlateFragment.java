package com.bodrumlife.mobilesoft365.FragmentBodRumLife;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
import com.bodrumlife.mobilesoft365.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BruSD on 28.08.13.
 */

public class MainPlateFragment extends Fragment {

    private Activity parentActivity = null;
    private ListView listOfEvents;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        View v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_main_plate_layout, null);
        listOfEvents = (ListView) v.findViewById(R.id.list_bodrum_event);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        //SimpleAdapter adapter = new SimpleAdapter(parentActivity,createShortEventList(), );
    }
    private List<Map<String, ?>> createShortEventList(){
        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();

        try {
            for (int i = 0 ; i < 4 ; i++){
              items.add(DataStorage.getEventList().get(i));            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

}
