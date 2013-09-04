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
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bodrumlife.mobilesoft365.AsyncTask.AsyncTaskFourItems;
import com.bodrumlife.mobilesoft365.AsyncTask.Enumeration_Bodrum;
import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
import com.bodrumlife.mobilesoft365.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofia on 8/31/13.
 */
public class ConcertFragment extends Fragment {
    private Activity parentActivity;
    List<HashMap<String,?>> list1 = new ArrayList<HashMap<String,?>>();
    private View v;
    private ListView listOfConcerts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        parentActivity = getActivity();
        v = LayoutInflater.from(parentActivity).inflate(R.layout.fragment_concert_layout, null);
        listOfConcerts =(ListView)v.findViewById(R.id.fragmant_concert_list);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        ConcertAdapter adapter = new ConcertAdapter(parentActivity,
                createShortEventList(),
                R.layout.item_for_concert_list,
                new String[]{"Name","Details"},
                new int[]{R.id.title_concert, R.id.text_concert } );
        listOfConcerts.setAdapter(adapter);


    }
    private List<Map<String, ?>> createShortEventList(){
        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();

        try {
            for (int i = 0 ; i <8; i++){
                items.add(DataStorage.getEventList().get(i));            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }



    private class ConcertAdapter extends SimpleAdapter {
        private Context context;
        private List<? extends Map<String, ?>> data;
        private int resource;


        public ConcertAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
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
            TextView titleOfConcert;
            TextView textConcert;
            ImageView imageOfConcert;

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

            holder = new ViewHolder();

            holder. titleOfConcert = (TextView)convertView.findViewById(R.id.title_concert);
            holder. titleOfConcert.setText(data.get(position).get("Name").toString());

            holder.textConcert = (TextView)convertView.findViewById(R.id.text_concert);
            holder.textConcert.setText(data.get(position).get("Details").toString());

            holder.imageOfConcert = (ImageView)convertView.findViewById(R.id.imageView_concert);
            holder.imageOfConcert.setImageBitmap((Bitmap) data.get(position).get("Image"));

            convertView.requestLayout();

            return convertView;
        }
    }

}
