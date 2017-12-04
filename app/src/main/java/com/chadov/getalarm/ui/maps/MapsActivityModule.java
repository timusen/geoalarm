package com.chadov.getalarm.ui.maps;

import com.chadov.getalarm.model.GeofenceRepository;
import com.chadov.getalarm.ui.maps.listfragment.GeofenceListFragment;
import com.chadov.getalarm.ui.maps.listfragment.GeofenceListFragmentComponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChadovTA on 27.11.2017.
 */

@Module (subcomponents = GeofenceListFragmentComponent.class)
public class MapsActivityModule {

    @Provides
    @MapsScope
    MapsView provideMainView(MapsActivity mapsActivity){
        return mapsActivity;
    }

    @Provides
    @MapsScope
    MapsPresenter provideMainPresenter(MapsView mapsView, GeofenceRepository repository){
        return new MapsPresenterImpl(mapsView, repository);
    }
}
