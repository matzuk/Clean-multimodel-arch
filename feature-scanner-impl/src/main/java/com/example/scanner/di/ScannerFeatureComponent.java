package com.example.scanner.di;

import com.example.core.di.app.CoreUtilsApi;
import com.example.core.di.general.PerFeature;
import com.example.core_db_api.di.CoreDbApi;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.feature_scanner_api.ScannerFeatureApi;
import com.example.purchase_api.di.PurchaseFeatureApi;
import com.example.scanner.presentation.view.ScannerActivity;

import dagger.Component;

@Component(modules = {
    ScannerFeatureModule.class,
    ScreenNavigationModule.class
}, dependencies = ScannerFeatureDependencies.class)
@PerFeature
public abstract class ScannerFeatureComponent implements ScannerFeatureApi {

    private static volatile ScannerFeatureComponent sScannerFeatureComponent;

    public static ScannerFeatureApi initAndGet(ScannerFeatureDependencies scannerFeatureDependencies) {
        if (sScannerFeatureComponent == null) {
            synchronized (ScannerFeatureComponent.class) {
                if (sScannerFeatureComponent == null) {
                    sScannerFeatureComponent = DaggerScannerFeatureComponent.builder()
                        .scannerFeatureDependencies(scannerFeatureDependencies)
                        .build();
                }
            }
        }
        return sScannerFeatureComponent;
    }

    public static ScannerFeatureComponent get() {
        if (sScannerFeatureComponent == null) {
            throw new RuntimeException("You must call 'initAndGet(ScannerFeatureDependenciesComponent scannerFeatureDependenciesComponent)' method");
        }
        return sScannerFeatureComponent;
    }

    public void resetComponent() {
        sScannerFeatureComponent = null;
    }

    public abstract void inject(ScannerActivity scannerActivity);

    public abstract ScannerScreenComponent scannerScreenComponent();

    @Component(dependencies = {
        CoreUtilsApi.class,
        CoreNetworkApi.class,
        CoreDbApi.class,
        PurchaseFeatureApi.class
    })
    @PerFeature
    interface ScannerFeatureDependenciesComponent extends ScannerFeatureDependencies { }

}
