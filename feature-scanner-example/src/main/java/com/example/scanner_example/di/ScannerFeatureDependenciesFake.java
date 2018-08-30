package com.example.scanner_example.di;

import com.example.core.di.app.CoreUtilsComponent;
import com.example.core.utils.SomeUtils;
import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.scanner.di.ScannerFeatureDependencies;
import com.example.scanner_example.fake.DbClientFake;
import com.example.scanner_example.fake.HttpClientFake;
import com.example.scanner_example.fake.PurchaseInteractorFake;

public class ScannerFeatureDependenciesFake implements ScannerFeatureDependencies {

    @Override
    public DbClientApi dbClient() {
        return new DbClientFake();
    }

    @Override
    public HttpClientApi httpClient() {
        return new HttpClientFake();
    }

    @Override
    public SomeUtils someUtils() {
        return CoreUtilsComponent.get().someUtils();
    }

    @Override
    public PurchaseInteractor purchaseInteractor() {
        return new PurchaseInteractorFake();
    }

}
