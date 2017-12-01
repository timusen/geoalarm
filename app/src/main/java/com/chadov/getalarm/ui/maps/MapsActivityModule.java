package com.chadov.getalarm.ui.maps;

import com.chadov.getalarm.MapsActivity;
import com.chadov.getalarm.model.GeofenceRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChadovTA on 27.11.2017.
 */


@Module
public class MapsActivityModule {

    @Provides
    MapsView provideMainView(MapsActivity mapsActivity){
        return mapsActivity;
    }

    @Provides
    MapsPresenter provideMainPresenter(MapsView mapsView, GeofenceRepository repository){
        return new MapsPresenterImpl(mapsView, repository);
    }
}
