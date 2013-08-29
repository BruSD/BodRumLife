package com.bodrumlife.mobilesoft365.AsyncTask;

/**
 * Created by Sofia on 8/29/13.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
import com.bodrumlife.mobilesoft365.MyActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AsyncTaskFourItems extends AsyncTask<String, Void, List<HashMap<String, ?>>> {

    private Activity activity;
    ProgressDialog dialog;
    String result = "";
    JSONArray jsonObject = null;

    public AsyncTaskFourItems(Activity activity){
        this.activity = activity;

    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Loading list");
        dialog.show();
    }

    @Override
    protected List <HashMap<String,?>>  doInBackground(String... params) {

        List <HashMap<String,?>> list1 = new ArrayList<HashMap<String,?>>();
        URL url = null;
        JSONArray mArray=null;


        try {
            url = new URL("http://bodrumlife.com/service/index.php?cat="+params[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream stream = conn.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String line;
                while((line =rd.readLine() )!=null)
                {
                    builder.append(line);
                }
                result=builder.toString();
                mArray = new JSONArray(result);

                for (int i = 0; i < mArray.length(); i++) {
                    JSONObject object = mArray.getJSONObject(i);
                    String id = object.getString("Id");
                    String name = object.getString("Name");
                    String details = object.getString("Details");
                    String image = object.getString("Image");


                    HashMap<String,Object> item;
                    item = new HashMap <String, Object >();
                    item.put("Id",id);
                    item.put("Name", name);
                    item.put("Details",details);
                    item.put("Image",image);
                    list1.add(item);
                }
            }
        }

        catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

         return list1;
    }

    @Override
    protected void onPostExecute(List<HashMap<String, ?>> hashMaps) {
        super.onPostExecute(hashMaps);

        saveListInDataStoreg(hashMaps);

        if(dialog!=null && dialog.isShowing())
            dialog.dismiss();

        if (activity != null && activity instanceof MyActivity) {
            ((MyActivity)activity).comitMainPlateFragment();

        }
    }

    private void saveListInDataStoreg(List<HashMap<String, ?>> listToDataStoreg){

        DataStorage.setEventList(listToDataStoreg);
    }
}
