package com.example.eugene_matsyuk.dagger_arch.di.app;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication;
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.internal.Preconditions;

@Component(modules = {
        AppModule.class,
        GlobalNavigationModule.class
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

    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

    public abstract void inject(MainActivity mainActivity);
    public abstract void inject(DaggerArchApplication daggerArchApplication);

    public abstract MainScreenComponent mainScreenComponent();

}
