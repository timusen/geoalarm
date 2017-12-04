package com.chadov.getalarm.dagger;

import android.app.Application;

import com.chadov.getalarm.GeoAlarmApp;
import com.chadov.getalarm.ui.maps.MapsActivityComponent;
import com.chadov.getalarm.ui.maps.MapsActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ChadovTA on 24.11.2017.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(GeoAlarmApp app);
}

