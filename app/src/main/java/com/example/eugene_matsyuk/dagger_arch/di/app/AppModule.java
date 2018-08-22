package com.example.eugene_matsyuk.dagger_arch.di.app;

import android.content.Context;

import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext() {
        return DaggerArchApplication.getAppContext();
    }

}
