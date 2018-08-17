package com.example.scanner_example.di;

import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.core.di.general.PerFeature;
import com.example.core.utils.SomeUtils;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.scanner_example.fake.PurchaseInteractorFake;

import dagger.Module;
import dagger.Provides;

@Module
public class ScannerFeatureDependenciesFakeModule {

    @Provides
    @PerFeature
    public DbClient dbClient() {
        return new DbClient();
    }

    @Provides
    @PerFeature
    public HttpClient httpClient() {
        return new HttpClient();
    }

    @Provides
    @PerFeature
    public SomeUtils someUtils() {
        return new SomeUtils();
    }

    @Provides
    @PerFeature
    public PurchaseInteractor purchaseInteractor() {
        return new PurchaseInteractorFake();
    }

}
