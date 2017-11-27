package com.chadov.getalarm;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import com.chadov.getalarm.dagger.DaggerAppComponent;


public class GeoAlarmApp extends Application implements HasActivityInjector {

        @Inject
        DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

        @Override
        public void onCreate() {
            super.onCreate();
            DaggerAppComponent
                    .builder()
                    .application(this)
                    .build()
                    .inject(this);
        }

        @Override
        public DispatchingAndroidInjector<Activity> activityInjector() {
            return activityDispatchingAndroidInjector;
        }
    }
