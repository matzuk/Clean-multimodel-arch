package com.example.scanner.di;

import com.example.core.di.general.PerFeature;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class ScreenNavigationModule {

    private final Cicerone<Router> mCicerone;

    public ScreenNavigationModule() {
        mCicerone = Cicerone.create();
    }

    @PerFeature
    @Provides
    Router provideRouter() {
        return mCicerone.getRouter();
    }

    @PerFeature
    @Provides
    NavigatorHolder provideNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }

}
