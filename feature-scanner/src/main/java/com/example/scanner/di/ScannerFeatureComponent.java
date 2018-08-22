package com.example.scanner.di;

import com.example.core.di.general.PerFeature;
import com.example.scanner.presentation.view.ScannerActivity;

import dagger.Component;

@Component(modules = ScannerFeatureModule.class, dependencies = ScannerFeatureDependencies.class)
@PerFeature
public abstract class ScannerFeatureComponent {

    private static volatile ScannerFeatureComponent sScannerFeatureComponent;

    public static void init(ScannerFeatureDependencies scannerFeatureDependencies) {
        sScannerFeatureComponent = DaggerScannerFeatureComponent.builder()
            .scannerFeatureDependencies(scannerFeatureDependencies)
            .build();
    }

    public static ScannerFeatureComponent get() {
        if (sScannerFeatureComponent == null) {
            throw new RuntimeException("You must call 'init(ScannerFeatureDependenciesComponent scannerFeatureDependenciesComponent)' method");
        }
        return sScannerFeatureComponent;
    }

    public void resetComponent() {
        sScannerFeatureComponent = null;
    }

    public abstract void inject(ScannerActivity scannerActivity);

    public abstract ScannerScreenComponent scannerScreenComponent();

}
