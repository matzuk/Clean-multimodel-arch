package com.example.antitheft.di;

import com.example.antitheft.data.repositories_impl.AntitheftRepositoryImpl;
import com.example.antitheft.domain.AntitheftInteractor;
import com.example.antitheft.domain.AntitheftInteractorImpl;
import com.example.antitheft.domain.AntitheftRepository;
import com.example.antitheft.start.AntitheftStarterImpl;
import com.example.core.di.general.PerFeature;
import com.example.feature_antitheft_api.AntitheftStarter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AntitheftFeatureModule {

    @PerFeature
    @Binds
    public abstract AntitheftRepository provideAntitheftRepository(AntitheftRepositoryImpl antitheftRepository);

    @PerFeature
    @Binds
    public abstract AntitheftInteractor provideAntitheftInteractor(AntitheftInteractorImpl antitheftInteractor);

    @PerFeature
    @Binds
    public abstract AntitheftStarter provideAntitheftStarter(AntitheftStarterImpl antitheftStarter);

}
