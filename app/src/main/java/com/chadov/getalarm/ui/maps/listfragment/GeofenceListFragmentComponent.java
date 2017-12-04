package com.chadov.getalarm.ui.maps.listfragment;

/**
 * Created by ChadovTA on 04.12.2017.
 */

import com.chadov.getalarm.ui.maps.MapsScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@GeofenceListScope
@Subcomponent(modules = GeofenceListFragmentModule.class)
public interface GeofenceListFragmentComponent extends AndroidInjector<GeofenceListFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GeofenceListFragment> {
    }
}
