package com.chadov.getalarm.ui.maps.listfragment;

import com.chadov.getalarm.ui.maps.MapsScope;
import com.google.android.gms.wearable.MessageApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChadovTA on 04.12.2017.
 */

@Module
public class GeofenceListFragmentModule {

    @GeofenceListScope
    @Provides
    GeofenceListFragmentView provideGeofenceListFragmentView(GeofenceListFragment fragment){
        return fragment;
    }

    @GeofenceListScope
    @Provides
    GeofenceListFragmentPresenter provideGeofenceListFragmentPresenter(GeofenceListFragmentView view){
        return new GeofenceListFragmentPresenterImpl(view);
    }
}
