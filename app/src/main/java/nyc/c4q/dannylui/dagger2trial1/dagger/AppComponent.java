package nyc.c4q.dannylui.dagger2trial1.dagger;

import javax.inject.Singleton;

import dagger.Component;
import nyc.c4q.dannylui.dagger2trial1.MainActivity;
import nyc.c4q.dannylui.dagger2trial1.dagger.modules.AppModule;
import nyc.c4q.dannylui.dagger2trial1.dagger.modules.NetModule;

/**
 * Created by dannylui on 1/12/17.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
