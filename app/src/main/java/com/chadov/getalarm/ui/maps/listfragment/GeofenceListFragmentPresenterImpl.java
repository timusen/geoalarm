package com.chadov.getalarm.ui.maps.listfragment;

import com.chadov.getalarm.model.Geofence;
import com.chadov.getalarm.model.GeofenceRepository;

import javax.inject.Inject;

/**
 * Created by ChadovTA on 04.12.2017.
 */

public class GeofenceListFragmentPresenterImpl implements GeofenceListFragmentPresenter {

    GeofenceListFragmentView mView;
    GeofenceRepository mRepository;


    @Inject
    public GeofenceListFragmentPresenterImpl(GeofenceListFragmentView view, GeofenceRepository repository) {
        mView = view;
        mRepository = repository;
    }

    public void loadGeofences()
    {
        mView.setGeofences(mRepository.getGeofences());
    }

    @Override
    public void changeGeofenceState(Geofence geofence, boolean active) {

    }
}
