package com.chadov.getalarm.dagger;

import android.app.Activity;

import com.chadov.getalarm.MapsActivity;
import com.chadov.getalarm.ui.maps.MapsActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by ChadovTA on 27.11.2017.
 */

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MapsActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMapsActivity(MapsActivityComponent.Builder builder);


}
