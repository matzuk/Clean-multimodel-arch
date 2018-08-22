package com.example.eugene_matsyuk.dagger_arch.di.app;

import android.support.annotation.NonNull;

import com.example.core.di.app.CoreUtilsApi;
import com.example.core_db_api.di.CoreDbApi;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication;
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;

@Component(
    modules = {
        GlobalNavigationModule.class,
        AppModule.class
}, dependencies = {
        CoreUtilsApi.class,
        CoreNetworkApi.class,
        CoreDbApi.class
})
@Singleton
public abstract class AppComponent implements CoreUtilsApi, CoreNetworkApi, CoreDbApi {

    private static volatile AppComponent sInstance;

    @NonNull
    public static AppComponent get() {
        return Preconditions.checkNotNull(sInstance,
                "AppComponent is not initialized yet. Call init first.");
    }

    public static void init(@NonNull AppComponent component) {
        if (sInstance != null) {
            throw new IllegalArgumentException("AppComponent is already initialized.");
        }
        sInstance = component;
    }

    public abstract void inject(MainActivity mainActivity);
    public abstract void inject(DaggerArchApplication daggerArchApplication);

    public abstract MainScreenComponent mainScreenComponent();

}
