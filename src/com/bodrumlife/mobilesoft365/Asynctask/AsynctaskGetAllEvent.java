package com.bodrumlife.mobilesoft365.AsyncTask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ListView;

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

/**
 * Created by Sofia on 8/28/13.
 */
public class AsyncTaskGetAllEvent extends AsyncTask<Void, Void, List<HashMap<String, ?>>> {
    private Activity activity;
    ProgressDialog dialog;
    String result = "";
    JSONArray jsonObject = null;

    public AsyncTaskGetAllEvent(Activity activity){
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
    protected List <HashMap<String,?>>  doInBackground(Void... params) {

        List <HashMap<String,?>> list1 = new ArrayList <HashMap<String,?>>();
        URL url = null;
        JSONArray mArray=null;

        try {
            url = new URL("http://bodrumlife.com/service/index.php?cat=1");
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
                    String name = object.getString("Name");
                    String id = object.getString("Id");
                    String details = object.getString("Details");
                    String image = object.getString("Image");
//                    String text = object.getString("text");

                    HashMap<String,Object> item;
                    item = new HashMap <String, Object >();
                        item.put("Name", name);
                        item.put("Id",id);
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

        try {

            jsonObject=new JSONArray(result);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return list1;
    }

    @Override
    protected void onPostExecute(List<HashMap<String, ?>> hashMaps) {
        super.onPostExecute(hashMaps);
        dialog.dismiss();
    }
}