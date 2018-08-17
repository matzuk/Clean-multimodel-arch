package com.example.eugene_matsyuk.dagger_arch.di.scanner;

import com.example.core.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.scanner.ScannerRepositoryImpl;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerInteractor;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerInteractorImpl;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ScannerFeatureModule {

    @PerFeature
    @Binds
    public abstract ScannerRepository provideScannerRepository(ScannerRepositoryImpl scannerRepository);

    @PerFeature
    @Binds
    public abstract ScannerInteractor provideScannerInteractor(ScannerInteractorImpl scannerInteractor);

}
