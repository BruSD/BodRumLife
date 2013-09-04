package com.bodrumlife.mobilesoft365.FragmentBodRumLife;



import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskFourItems;
import com.bodrumlife.mobilesoft365.AsyncTask.Enumeration_Bodrum;
import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
import com.bodrumlife.mobilesoft365.MyActivity;
import com.bodrumlife.mobilesoft365.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Contains fragment of main page with layout fragment_main_plate_layout
 * @author  BruSD
 * @version 1.0 28.08.13.
 */

public class MainPlateFragment extends Fragment {

    private Activity parentActivity = null;
    private ListView listOfEvents;
    private RelativeLayout wheareToGoRL;
    private static int listHigth;
    private View v;
    private ImageView imageLogoBodRum;
    private RelativeLayout imageConcert;
    private int totalDistruction;
    private ViewGroup header;
    private RelativeLayout shopingButton;

    /**
     * Creates and returns the view fragment_main_plate_layout
     * @param inflater the LayoutInflater object that used to inflate LayoutInflater with fragment_main_plate_layout
     * @return return the View for the fragment's
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_main_plate_layout, null);
        listOfEvents = (ListView) v.findViewById(R.id.list_bodrum_event);
        imageLogoBodRum = (ImageView)v.findViewById(R.id.bodrum_logo_image_main_plate_layout);
        imageConcert=(RelativeLayout)v.findViewById(R.id.concert_button_main_plate);
        imageConcert.setOnClickListener(new startConcertFragment());
        imageLogoBodRum.setOnClickListener(new startAboutBodRumFragment() );

        wheareToGoRL = (RelativeLayout)v.findViewById(R.id.wheare_to_go_main_plate_fragmet);

        shopingButton = (RelativeLayout)v.findViewById(R.id.shoping_button_main_plate);
        shopingButton.setOnClickListener(new startListShopingFragment());
        totalDistruction = (parentActivity.getWindowManager().getDefaultDisplay().getHeight()/12);
        return v;
    }

    /**
     * Called when the Fragment is visible to the user. Runs adapter EventAdapter
     * LayoutInflater object that used to inflate LayoutInflater with head_list_of_events and listOfEvents, get head of list_bodrum_event
     */

    @Override
    public void onStart() {
        super.onStart();
        listHigth = v.getMeasuredHeight() - wheareToGoRL.getHeight();

        header = (ViewGroup)LayoutInflater.from(getActivity()).inflate(R.layout.head_list_of_events, listOfEvents, false);
        ViewGroup.LayoutParams params = header.getLayoutParams();
        params.height = totalDistruction+4;
        header.setLayoutParams(params);
        header.requestLayout();

        if(listOfEvents.getHeaderViewsCount() == 0){
            listOfEvents.addHeaderView(header, null, false);
        }

        EventAdapter adapter = new EventAdapter(parentActivity,
                createShortEventList(),
                R.layout.iteme_for_event_main_plate_list,
                new String[]{"Name","Details"},
                new int[]{R.id.title_of_event, R.id.details_of_event } );
        listOfEvents.setAdapter(adapter);
    }

    /**
     * Created list of HashMaps consist of 4 items
     * @return list
     */
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

    /**
     * Created adapter EventAdapter.
     */

    private class EventAdapter extends SimpleAdapter {
        private Context context;
        private List<? extends Map<String, ?>> data;
        private int resource;

        /**
         * Creates the object-connector linked list with createShortEventList
         * @param context
         * @param data list of Maps
          */

        public EventAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.context = context;
            this.data = data;
            this.resource = resource;
            }

            /**
             * <p>Count of items in the data set represented by this Adapter</p>
             * @return How many items are in the data set represented by this Adapter
             */
            @Override
            public int getCount() {
                return data.size();
            }

            /**
             * <p>Get the data item associated with the specified position in the data set.</p>
             * @param position Position of the item whose data we want within the adapter's data set.
             * @return The data at the specified position
             */
            @Override
            public Object getItem(int position) {
                return null;
            }

            /**
             * <p>Get the row id associated with the specified position in the list.</p>
             * @param position The position of the item within the adapter's data set whose row id we want
             * @return The id of the item at the specified position
             */
            @Override
            public long getItemId(int position) {
                return position;
            }

            public class ViewHolder {
                TextView titleOfEvent;
                TextView descriptionOfEvent;
                ImageView imageOfEvent;

            }

            /**
             * <p>Get a View that displays the data at the specified position in the data set.</p>
             * @param position   The position of the item within the adapter's data set of the item whose view we want
             * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using. If it is not possible to convert this view to display the correct data, this method can create a new view
             * @param parent The parent that this view will eventually be attached to
             * @return  A View corresponding to the data at the specified position
             */
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                final ViewHolder holder;

                LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = li.inflate(resource, parent, false);
                ViewGroup.LayoutParams params = convertView.getLayoutParams();
                params.height = totalDistruction;




                holder = new ViewHolder();

                holder.titleOfEvent = (TextView)convertView.findViewById(R.id.title_of_event);
                holder.titleOfEvent.setText(data.get(position).get("Name").toString());
                
                holder.descriptionOfEvent = (TextView)convertView.findViewById(R.id.details_of_event);
                holder.descriptionOfEvent.setText(data.get(position).get("Details").toString());
                
                holder.imageOfEvent = (ImageView)convertView.findViewById(R.id.image_of_evante);

                holder.imageOfEvent.setImageBitmap((Bitmap) data.get(position).get("Image"));


                convertView.setLayoutParams(params);
                convertView.requestLayout();

                return convertView;
            }
    }

    /**
     * Runs AsyncTask for Concerts and runs startAboutBodRumFragment listen on click
     */


    class startAboutBodRumFragment implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (parentActivity != null && parentActivity instanceof MyActivity)
                ((MyActivity)parentActivity).comitAboutBodRum();
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

                new AsyncTaskFourItems(getActivity()).execute(String.valueOf(Enumeration_Bodrum.TypeOfAsyncTask.Concerts.getValue()));

            }
        }
    }

    /**
     *
     */
    class startListShopingFragment implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (parentActivity != null && parentActivity instanceof MyActivity)
                ((MyActivity)parentActivity).comitListBodRumFragment(Enumeration_Bodrum.TypeOfAsyncTask.Shopping.getValue());
        }
    }
    class startConcertFragment implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (parentActivity != null && parentActivity instanceof MyActivity)
                ((MyActivity)parentActivity).comitConcert();
        }
    }
}
