package com.bodrumlife.mobilesoft365.DataBodRumLife;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;

import java.net.URL;

/**
 * Created by BruSD on 29.08.13.
 */
public class DetailItemBodRum {
    private int item_id;
    private String item_name;
    private URL item_image_url;
    private Drawable item_image;
    private String item_detail;
    private String item_email;
    private URL item_website;
    private URL item_support_website;
    private LatLng item_location = new LatLng(0,0);

}
