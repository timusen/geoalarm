package com.chadov.getalarm.model;

import java.util.List;
import java.util.UUID;

/**
 * Created by ChadovTA on 01.12.2017.
 */

public interface GeofenceRepository {

    List<Geofence> getGeofences();

    //Geofence get(UUID id);

    void addNew(Geofence geofence);

    boolean delete(Geofence geofence);
}
