package com.example.antitheft.di;

import com.example.antitheft.presentation.view.AntitheftActivity;
import com.example.core.di.app.CoreUtilsApi;
import com.example.core.di.general.PerFeature;
import com.example.core_db_api.di.CoreDbApi;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.feature_antitheft_api.AntitheftFeatureApi;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(modules = {
    AntitheftFeatureModule.class,
    AntitheftNavigationModule.class
}, dependencies = AntitheftFeatureDependencies.class)
@PerFeature
public abstract class AntitheftFeatureComponent implements AntitheftFeatureApi {

    private static volatile AntitheftFeatureComponent sAntitheftFeatureComponent;

    public static AntitheftFeatureApi initAndGet(AntitheftFeatureDependencies antitheftFeatureDependencies) {
        if (sAntitheftFeatureComponent == null) {
            synchronized (AntitheftFeatureComponent.class) {
                if (sAntitheftFeatureComponent == null) {
                    sAntitheftFeatureComponent = DaggerAntitheftFeatureComponent.builder()
                        .antitheftFeatureDependencies(antitheftFeatureDependencies)
                        .build();
                }
            }
        }
        return sAntitheftFeatureComponent;
    }

    public static AntitheftFeatureComponent get() {
        if (sAntitheftFeatureComponent == null) {
            throw new RuntimeException("You must call 'initAndGet(AntitheftFeatureDependencies antitheftFeatureDependencies)' method");
        }
        return sAntitheftFeatureComponent;
    }

    public void resetComponent() {
        sAntitheftFeatureComponent = null;
    }

    public abstract void inject(AntitheftActivity antitheftActivity);

    public abstract AntitheftScreenComponent antitheftScreenComponent();

    @Component(dependencies = {
        CoreUtilsApi.class,
        CoreNetworkApi.class,
        CoreDbApi.class,
        PurchaseFeatureApi.class
    })
    @PerFeature
    interface AntitheftFeatureDependenciesComponent extends AntitheftFeatureDependencies { }

}
