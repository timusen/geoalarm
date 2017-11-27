package com.chadov.getalarm.dagger;

import android.app.Application;
import android.content.Context;

import com.chadov.getalarm.ui.maps.MapsActivityComponent;

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
}
