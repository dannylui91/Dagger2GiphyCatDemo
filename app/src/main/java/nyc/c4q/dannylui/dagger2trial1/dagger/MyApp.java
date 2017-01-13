package nyc.c4q.dannylui.dagger2trial1.dagger;

import android.app.Application;

import nyc.c4q.dannylui.dagger2trial1.dagger.modules.AppModule;
import nyc.c4q.dannylui.dagger2trial1.dagger.modules.NetModule;

/**
 * Created by dannylui on 1/12/17.
 */

public class MyApp extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger
        mAppComponent = DaggerAppComponent.builder() // Dagger"AppComponent" will be the same name corresponding to your component name
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.giphy.com/"))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
