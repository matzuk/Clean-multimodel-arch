package com.example.scanner_example.di;

import com.example.core.di.general.PerFeature;
import com.example.scanner.di.ScannerFeatureDependencies;

import dagger.Component;

@Component(modules = ScannerFeatureDependenciesFakeModule.class)
@PerFeature
public abstract class ScannerFeatureDependenciesFakeComponent implements ScannerFeatureDependencies {

    public static ScannerFeatureDependencies create() {
        return DaggerScannerFeatureDependenciesFakeComponent.builder()
            .build();
    }

}
