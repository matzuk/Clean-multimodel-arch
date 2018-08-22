package com.example.scanner_example.di;

import com.example.core.di.general.PerFeature;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.scanner_example.fake.PurchaseInteractorFake;

import dagger.Module;
import dagger.Provides;

@Module
public class ScannerFeatureDependenciesFakeModule {

    @Provides
    @PerFeature
    public PurchaseInteractor purchaseInteractor() {
        return new PurchaseInteractorFake();
    }

}
