package com.chadov.getalarm.ui.maps;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by ChadovTA on 27.11.2017.
 */

public class MapsPresenterImpl implements MapsPresenter {

    @Inject
    public MapsView mMapsView;

    public MapsPresenterImpl(MapsView mapsView)
    {
        mMapsView = mapsView;
    }

    public void addNewGeofence()
    {

    }
}
