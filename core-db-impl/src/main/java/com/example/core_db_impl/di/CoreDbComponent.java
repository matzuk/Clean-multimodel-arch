package com.example.core_db_impl.di;

import com.example.core_db_api.di.CoreDbApi;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = DbModule.class)
@Singleton
public abstract class CoreDbComponent implements CoreDbApi {

    /**
     * Call only one time!
     * @return CoreDbComponent
     */
    public static CoreDbComponent createOnce() {
        return DaggerCoreDbComponent.builder().build();
    }

}
