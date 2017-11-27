package com.chadov.getalarm.ui.maps;

import com.chadov.getalarm.MapsActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by ChadovTA on 27.11.2017.
 */


@Subcomponent(modules = MapsActivityModule.class)
public interface MapsActivityComponent extends AndroidInjector<MapsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MapsActivity>{}
}
