package com.example.scanner_example.di;

import com.example.core.di.general.PerFeature;
import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.scanner_example.fake.DbClientFake;
import com.example.scanner_example.fake.HttpClientFake;
import com.example.scanner_example.fake.PurchaseInteractorFake;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ScannerFeatureDependenciesFakeModule {

    @Provides
    @PerFeature
    public static PurchaseInteractor purchaseInteractor() {
        return new PurchaseInteractorFake();
    }

    @PerFeature
    @Binds
    public abstract DbClientApi provideDbClientApi(DbClientFake dbClient);

    @PerFeature
    @Binds
    public abstract HttpClientApi provideHttpClientApi(HttpClientFake httpClientFake);

}
