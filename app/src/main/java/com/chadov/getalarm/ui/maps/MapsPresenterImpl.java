package com.chadov.getalarm.ui.maps;

import com.chadov.getalarm.model.Geofence;
import com.chadov.getalarm.model.GeofenceRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by ChadovTA on 27.11.2017.
 */

public class MapsPresenterImpl implements MapsPresenter {

    public MapsView mMapsView;
    public GeofenceRepository mRepository;

    @Inject
    public MapsPresenterImpl(MapsView mapsView, GeofenceRepository repository)    {
        mMapsView = mapsView;
        mRepository = repository;
    }

    public void addNewGeofence(Geofence geofence)
    {
        mRepository.addNew(geofence);
        mMapsView.selectGeofence(geofence);
    }
}
