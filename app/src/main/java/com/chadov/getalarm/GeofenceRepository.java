package com.chadov.getalarm;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ChadovTA on 16.10.2017.
 */

public class GeofenceRepository {
    private static GeofenceRepository sGeofenceRepository;
    public static GeofenceRepository get(Context context) {
        if (sGeofenceRepository == null) {
            sGeofenceRepository = new GeofenceRepository(context);
        }
        return sGeofenceRepository;
    }
    private GeofenceRepository(Context context) {
        mGeofences = new ArrayList<>();
        Initialize();
    }

    private void Initialize() {
        mGeofences.add(new Geofence("Московская дача", 56.540358, 38.036717, 3));
        mGeofences.add(new Geofence("Лесная дача", 56.15638889, 45.21583333, 10));
    }

    private List<Geofence> mGeofences;

    public List<Geofence> getGeofences() {
        return mGeofences;
    }
    public Geofence getCrime(UUID id) {
        for (Geofence geo : mGeofences) {
            if (geo.getId().equals(id)) {
                return geo;
            }
        }
        return null;
    }
}
