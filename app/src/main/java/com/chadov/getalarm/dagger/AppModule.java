package com.chadov.getalarm.dagger;

import android.app.Application;
import android.content.Context;

import com.chadov.getalarm.model.GeofenceRepository;
import com.chadov.getalarm.model.GeofenceRepositoryImpl;
import com.chadov.getalarm.ui.maps.MapsActivityComponent;
import com.chadov.getalarm.utils.GoogleApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChadovTA on 24.11.2017.
 */

@Module(subcomponents = {
        MapsActivityComponent.class        })
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    GoogleApi googleApi(Context context) { return new GoogleApi(context);}

    @Provides
    @Singleton
    GeofenceRepository geofenceRepository(Context context) { return new GeofenceRepositoryImpl(context); }
}
