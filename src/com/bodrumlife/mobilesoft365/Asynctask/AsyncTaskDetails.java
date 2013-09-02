package com.bodrumlife.mobilesoft365.AsyncTask;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bodrumlife.mobilesoft365.DataBodRumLife.DataStorage;
import com.bodrumlife.mobilesoft365.R;

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
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sofia on 8/29/13.
 */
public class AsyncTaskDetails extends AsyncTask<String, Void, JSONObject> {
    private Activity activity;
    ProgressDialog dialog;
    String result = "";

    public AsyncTaskDetails(Activity activity){
        this.activity = activity;
           }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        dialog=new ProgressDialog(activity);
        dialog.show();
        dialog.setContentView(R.layout.loader_layout);
     }

    @Override
    protected JSONObject doInBackground(String... params) {
        URL url = null;
        JSONObject jsonO=null;
        if(params.length<1){
            return jsonO;
        }
        try {
            url = new URL("http://bodrumlife.com/service/index.php?id="+params[0]+"&cat="+params[1]);
        } catch (MalformedURLException e) {
            return jsonO;
        }
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream stream = conn.getInputStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        builder.append(line);
                    }
                    result = builder.toString();
                    jsonO = new JSONObject(result);
                    String id = jsonO.getString("Id");
                    String name = jsonO.getString("Name");
                    String image = jsonO.getString("Image");
                    String addres = jsonO.getString("Addres");
                    String email = jsonO.getString("Email");
                    String website = jsonO.getString("Website");
                    String website2 = jsonO.getString("Website2");
                    String map = jsonO.getString("Map");
                    String detail = jsonO.getString("Detail");
                }
            }

        catch (IOException e) {
            e.printStackTrace();
           }

        catch (JSONException e) {
            e.printStackTrace();
           }
              return null;
    }
    @Override
    protected void onPostExecute( JSONObject hashMaps) {
        super.onPostExecute(hashMaps);
        if(dialog!=null && dialog.isShowing())
            dialog.dismiss();

    }
}
