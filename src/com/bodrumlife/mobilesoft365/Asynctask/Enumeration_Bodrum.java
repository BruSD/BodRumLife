package com.bodrumlife.mobilesoft365.AsyncTask;

/**
 * Created by Sofia on 8/28/13.
 */
public class Enumeration_Bodrum {
    public static enum TypeOfAsyncTask
    {
        Hotels(73),
        Restaurants(70),
        BarsCafe(71),
        Shopping(76),
        Events(1),
        Beach(103),
        Concerts(92),
        Gozumuze(88);

        private int mValue;
        TypeOfAsyncTask(int value) {
            this.mValue=value;
        }

        public int getValue() {
            return mValue;
        }
    }
}

