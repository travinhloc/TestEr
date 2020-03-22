package com.lt.test.di;

import com.lt.test.ui.MainContract;
import com.lt.test.ui.MainInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Modules aren't used by you directly, they're used by Dagger. @Provides annotated methods are
 * used to lookup classes during injection. @Singleton indicates that only one instance of the object
 * is used, and used everywhere when injected.
 */
@Module
public class InteractorModule {

    @Provides
    @Singleton
    static MainContract.Interactor providesMain() {
        return new MainInteractor(); }
}
