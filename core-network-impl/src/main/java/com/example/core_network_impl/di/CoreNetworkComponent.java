package com.example.core_network_impl.di;

import com.example.core_network_api.di.CoreNetworkApi;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public abstract class CoreNetworkComponent implements CoreNetworkApi {

    private static volatile CoreNetworkComponent sCoreNetworkComponent;

    public static CoreNetworkComponent get() {
        if (sCoreNetworkComponent == null) {
            synchronized (CoreNetworkComponent.class) {
                if (sCoreNetworkComponent == null) {
                    sCoreNetworkComponent = DaggerCoreNetworkComponent.builder().build();
                }
            }
        }
        return sCoreNetworkComponent;
    }

}
