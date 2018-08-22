package com.example.core_network_impl.di;

import com.example.core_network_api.di.CoreNetworkApi;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public abstract class CoreNetworkComponent implements CoreNetworkApi {

    /**
     * Call only one time!
     * @return CoreNetworkComponent
     */
    public static CoreNetworkComponent createOnce() {
        return DaggerCoreNetworkComponent.builder().build();
    }

}
