package com.example.scanner_example.di;

import com.example.core.di.app.CoreUtilsApi;
import com.example.core.di.general.PerFeature;
import com.example.scanner.di.ScannerFeatureDependencies;

import dagger.Component;

@Component(
    modules = {
        ScannerFeatureDependenciesFakeModule.class
}, dependencies = {
    CoreUtilsApi.class
})
@PerFeature
public abstract class ScannerFeatureDependenciesFakeComponent implements ScannerFeatureDependencies {

    public static ScannerFeatureDependencies create(CoreUtilsApi coreUtilsApi) {
        return DaggerScannerFeatureDependenciesFakeComponent.builder()
            .coreUtilsApi(coreUtilsApi)
            .build();
    }

}
