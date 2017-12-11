package com.chadov.getalarm.ui.maps.listfragment;

import com.chadov.getalarm.model.Geofence;

/**
 * Created by ChadovTA on 04.12.2017.
 */

public interface GeofenceListFragmentPresenter {
    void loadGeofences();

    void changeGeofenceState(Geofence geofence, boolean active);
}
