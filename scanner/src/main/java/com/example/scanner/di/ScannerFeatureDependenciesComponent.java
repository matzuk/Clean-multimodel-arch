package com.example.scanner.di;

import com.example.core.di.app.GlobalAppApi;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(dependencies = {
    GlobalAppApi.class,
    PurchaseFeatureApi.class
})
public abstract class ScannerFeatureDependenciesComponent implements ScannerFeatureDependencies {
}
