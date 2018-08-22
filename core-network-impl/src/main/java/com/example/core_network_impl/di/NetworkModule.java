package com.example.core_network_impl.di;

import com.example.core_network_api.data.HttpClientApi;
import com.example.core_network_impl.data.HttpClientImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    public abstract HttpClientApi provideHttpClientApi(HttpClientImpl httpClient);

}
