package nyc.c4q.dannylui.dagger2trial1.dagger.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dannylui on 1/13/17.
 */

@Module
public class AppModule {
    Application mApplication;
    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}