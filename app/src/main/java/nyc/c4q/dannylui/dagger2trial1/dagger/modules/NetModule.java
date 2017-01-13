package nyc.c4q.dannylui.dagger2trial1.dagger.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nyc.c4q.dannylui.dagger2trial1.networks.GiphyClient;

/**
 * Created by dannylui on 1/13/17.
 */

@Module
public class NetModule {
    String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    public SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public GiphyClient provideGiphyClient() {
        return GiphyClient.getInstance();
    }
}
