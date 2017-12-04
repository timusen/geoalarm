package com.chadov.getalarm.ui.maps;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by ChadovTA on 27.11.2017.
 */

@MapsScope
@Subcomponent(
        modules =  {
            MapsActivityModule.class,
            GeofenceListFragmentProvider.class
        })
public interface MapsActivityComponent extends AndroidInjector<MapsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MapsActivity>{}
}
