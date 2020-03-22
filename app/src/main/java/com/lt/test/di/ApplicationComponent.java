package com.lt.test.di;

import com.lt.test.App;
import com.lt.test.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Newly added modules must be added to the @Component annotation here. You must also provide
 * further inject() methods for new classes that want to perform injection.
 */
@Singleton
@Component(modules = {InteractorModule.class, PresenterModule.class})
public interface ApplicationComponent {

    void inject(App app);

    void inject(MainActivity activity);

}
