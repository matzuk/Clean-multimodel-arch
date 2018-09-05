package com.example.scanner.di;

import com.example.core.di.general.PerFeature;
import com.example.feature_scanner_api.ScannerStarter;
import com.example.scanner.data.ScannerRepositoryImpl;
import com.example.scanner.domain.ScannerInteractor;
import com.example.scanner.domain.ScannerInteractorImpl;
import com.example.scanner.domain.ScannerRepository;
import com.example.scanner.start.ScannerStarterImpl;

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

    @PerFeature
    @Binds
    public abstract ScannerStarter provideScannerStarter(ScannerStarterImpl scannerStarter);

}
