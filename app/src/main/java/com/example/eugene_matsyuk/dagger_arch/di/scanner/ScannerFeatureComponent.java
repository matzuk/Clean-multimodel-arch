package com.example.eugene_matsyuk.dagger_arch.di.scanner;

import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.presentation.scanner.view.ScannerActivity;

import dagger.Component;

@Component(modules = ScannerFeatureModule.class, dependencies = ScannerFeatureDependencies.class)
@PerFeature
public abstract class ScannerFeatureComponent {

    private static volatile ScannerFeatureDependencies sScannerFeatureDependencies;
    private static volatile ScannerFeatureComponent sScannerFeatureComponent;

    public static void setScannerFeatureDependencies(ScannerFeatureDependencies scannerFeatureDependencies) {
        sScannerFeatureDependencies = scannerFeatureDependencies;
    }

    public static ScannerFeatureComponent get() {
        if (sScannerFeatureDependencies == null) {
            throw new RuntimeException("You must call setScannerFeatureDependencies(...) first before get() calling");
        }
        if (sScannerFeatureComponent == null) {
            synchronized (ScannerFeatureComponent.class) {
                if (sScannerFeatureComponent == null) {
                    sScannerFeatureComponent = createComponent(sScannerFeatureDependencies);
                }
            }
        }
        return sScannerFeatureComponent;
    }

    private static ScannerFeatureComponent createComponent(ScannerFeatureDependencies scannerFeatureDependencies) {
        return DaggerScannerFeatureComponent.builder()
            .scannerFeatureDependencies(scannerFeatureDependencies)
            .build();

    }

    public void resetComponent() {
        sScannerFeatureDependencies = null;
        sScannerFeatureComponent = null;
    }

    public abstract void inject(ScannerActivity scannerActivity);

    public abstract ScannerScreenComponent scannerScreenComponent();

}
