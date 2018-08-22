package com.example.scanner.di;

import com.example.core.di.app.CoreUtilsApi;
import com.example.core.di.general.PerFeature;
import com.example.core_db_api.di.CoreDbApi;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(dependencies = {
    CoreUtilsApi.class,
    CoreNetworkApi.class,
    CoreDbApi.class,
    PurchaseFeatureApi.class
})
@PerFeature
public abstract class ScannerFeatureDependenciesComponent implements ScannerFeatureDependencies {

    public static ScannerFeatureDependenciesComponent create(CoreUtilsApi coreUtilsApi,
                                                             CoreNetworkApi coreNetworkApi,
                                                             CoreDbApi coreDbApi,
                                                             PurchaseFeatureApi purchaseFeatureApi) {
        return DaggerScannerFeatureDependenciesComponent.builder()
            .coreNetworkApi(coreNetworkApi)
            .coreDbApi(coreDbApi)
            .coreUtilsApi(coreUtilsApi)
            .purchaseFeatureApi(purchaseFeatureApi)
            .build();
    }

}
