package com.chadov.getalarm.ui.maps.listfragment;

import com.chadov.getalarm.model.Geofence;

import javax.inject.Inject;

/**
 * Created by ChadovTA on 04.12.2017.
 */

public class GeofenceListFragmentPresenterImpl implements GeofenceListFragmentPresenter {
    GeofenceListFragmentView mView;

    @Inject
    public GeofenceListFragmentPresenterImpl(GeofenceListFragmentView view) {
        mView = view;
    }

    @Override
    public void changeGeofenceState(Geofence geofence, boolean active) {

    }
}
