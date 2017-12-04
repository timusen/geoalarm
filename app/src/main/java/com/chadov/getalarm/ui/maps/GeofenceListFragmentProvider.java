package com.chadov.getalarm.ui.maps;


import android.support.v4.app.Fragment;

import com.chadov.getalarm.ui.maps.listfragment.GeofenceListFragment;
import com.chadov.getalarm.ui.maps.listfragment.GeofenceListFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by ChadovTA on 04.12.2017.
 */

@Module
public abstract class GeofenceListFragmentProvider {

    @Binds
    @IntoMap
    @FragmentKey(GeofenceListFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideGeofenceListFragmentFactory(GeofenceListFragmentComponent.Builder builder);
}
