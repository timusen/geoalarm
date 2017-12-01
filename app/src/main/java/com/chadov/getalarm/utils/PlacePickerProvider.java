package com.chadov.getalarm.utils;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by ChadovTA on 30.11.2017.
 */

public class PlacePickerProvider {

    Context mContext;
    ISelectPlaceCallback mCallback;

    @Inject
    public  PlacePickerProvider(Context context, ISelectPlaceCallback callback)
    {
        mContext = context;
        mCallback = callback;
    }

    public interface ISelectPlaceCallback {
        void onPlaceSelected();
    }


}
