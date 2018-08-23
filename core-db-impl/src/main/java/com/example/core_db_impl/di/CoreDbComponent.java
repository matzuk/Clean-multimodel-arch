package com.example.core_db_impl.di;

import com.example.core_db_api.di.CoreDbApi;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = DbModule.class)
@Singleton
public abstract class CoreDbComponent implements CoreDbApi {

    private static volatile CoreDbComponent sCoreDbComponent;

    public static CoreDbComponent get() {
        if (sCoreDbComponent == null) {
            synchronized (CoreDbComponent.class) {
                if (sCoreDbComponent == null) {
                    sCoreDbComponent = DaggerCoreDbComponent.builder().build();
                }
            }
        }
        return sCoreDbComponent;
    }

}
