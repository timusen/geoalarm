package com.chadov.getalarm.ui.maps.listfragment;

import com.chadov.getalarm.model.Geofence;

import java.util.List;

/**
 * Created by ChadovTA on 04.12.2017.
 */

public interface GeofenceListFragmentView {
    void setGeofences(List<Geofence> geofences);

    void updateList();
}
