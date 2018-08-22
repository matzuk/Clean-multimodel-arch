package com.example.scanner_example.di;

import com.example.core.di.app.CoreUtilsApi;
import com.example.core.di.general.PerFeature;
import com.example.core_db_api.di.CoreDbApi;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.scanner.di.ScannerFeatureDependencies;

import dagger.Component;

@Component(
    modules = {
        ScannerFeatureDependenciesFakeModule.class
}, dependencies = {
    CoreUtilsApi.class,
    CoreNetworkApi.class,
    CoreDbApi.class
})
@PerFeature
public abstract class ScannerFeatureDependenciesFakeComponent implements ScannerFeatureDependencies {

    public static ScannerFeatureDependencies create(CoreUtilsApi coreUtilsApi, CoreNetworkApi coreNetworkApi, CoreDbApi coreDbApi) {
        return DaggerScannerFeatureDependenciesFakeComponent.builder()
            .coreDbApi(coreDbApi)
            .coreNetworkApi(coreNetworkApi)
            .coreUtilsApi(coreUtilsApi)
            .build();
    }

}
