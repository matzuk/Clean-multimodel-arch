package com.example.purchase_impl.di;

import com.example.core.di.general.PerFeature;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(
    dependencies = PurchaseFeatureDependencies.class,
    modules = PurchaseModule.class
)
@PerFeature
public abstract class PurchaseComponent implements PurchaseFeatureApi {

    public static PurchaseComponent create(PurchaseFeatureDependencies purchaseFeatureDependencies) {
        return DaggerPurchaseComponent.builder()
            .purchaseFeatureDependencies(purchaseFeatureDependencies)
            .build();
    }

    @Component(dependencies = CoreNetworkApi.class)
    @PerFeature
    interface PurchaseFeatureDependenciesComponent extends PurchaseFeatureDependencies { }

}
