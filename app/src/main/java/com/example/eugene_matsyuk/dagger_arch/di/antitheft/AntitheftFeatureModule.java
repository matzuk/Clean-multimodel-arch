package com.example.eugene_matsyuk.dagger_arch.di.antitheft;

import com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.antitheft.AntitheftRepositoryImpl;
import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.AntitheftInteractor;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.AntitheftInteractorImpl;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.AntitheftRepository;

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

}
