package com.example.eugene_matsyuk.dagger_arch.di.app;

import android.support.annotation.NonNull;

import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;

@Component(
    modules = {
        GlobalNavigationModule.class,
        AppModule.class
})
@Singleton
public abstract class AppComponent {

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

    public abstract void inject(DaggerArchApplication daggerArchApplication);

    public abstract MainScreenComponent mainScreenComponent();

}
