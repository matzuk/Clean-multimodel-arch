package com.example.core_db_impl.di;

import com.example.core_db_api.data.DbClientApi;
import com.example.core_db_impl.data.DbClientImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class DbModule {

    @Singleton
    @Binds
    public abstract DbClientApi provideDbClientApi(DbClientImpl dbClientImpl);

}
