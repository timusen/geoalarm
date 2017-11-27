package com.chadov.getalarm.dagger;

import android.app.Application;

import com.chadov.getalarm.GeoAlarmApp;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by ChadovTA on 24.11.2017.
 */

@Component(modules = {
        AndroidInjectionModule.class,
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

