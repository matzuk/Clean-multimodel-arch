package com.example.scanner.di;

import com.example.core.di.app.GlobalAppApi;
import com.example.core.di.general.PerFeature;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(dependencies = {
    GlobalAppApi.class,
    PurchaseFeatureApi.class
})
@PerFeature
public abstract class ScannerFeatureDependenciesComponent implements ScannerFeatureDependencies {

    public static ScannerFeatureDependenciesComponent create(GlobalAppApi globalAppApi, PurchaseFeatureApi purchaseFeatureApi) {
        return DaggerScannerFeatureDependenciesComponent.builder()
            .globalAppApi(globalAppApi)
            .purchaseFeatureApi(purchaseFeatureApi)
            .build();
    }

}
