package com.example.core.di.app;

import javax.inject.Singleton;

import dagger.Component;

@Component
@Singleton
public abstract class CoreUtilsComponent implements CoreUtilsApi {

    private static volatile CoreUtilsComponent sCoreUtilsComponent;

    public static CoreUtilsComponent get() {
        if (sCoreUtilsComponent == null) {
            synchronized (CoreUtilsComponent.class) {
                if (sCoreUtilsComponent == null) {
                    sCoreUtilsComponent = DaggerCoreUtilsComponent.builder().build();
                }
            }
        }
        return sCoreUtilsComponent;
    }

}
