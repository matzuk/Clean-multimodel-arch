package com.example.core.di.app;

import javax.inject.Singleton;

import dagger.Component;

@Component
@Singleton
public abstract class CoreUtilsComponent implements CoreUtilsApi {

    /**
     * Call only one time!
     * @return CoreUtilsComponent
     */
    public static CoreUtilsComponent createOnce() {
        return DaggerCoreUtilsComponent.builder().build();
    }

}
